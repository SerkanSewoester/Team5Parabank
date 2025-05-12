package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;

public class GWDParameter {

    private static final Logger logger = LoggerFactory.getLogger(GWDParameter.class);

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static final ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    /**
     * WebDriver nesnesini başlatır ve thread bazlı yönetim sağlar.
     *
     * @return WebDriver örneği
     */
    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadDriver.get() == null) {
            threadBrowserName.set("chrome");  // Varsayılan tarayıcı
            logger.warn("Tarayıcı tipi belirtilmedi. Varsayılan olarak Chrome kullanılacak.");
        }

        switch (threadBrowserName.get().toLowerCase()) {
            case "edge":
                logger.info("WebDriver başlatılıyor: Microsoft Edge");
                threadDriver.set(new EdgeDriver());
                break;
            case "firefox":
                logger.info("WebDriver başlatılıyor: Mozilla Firefox");
                threadDriver.set(new FirefoxDriver());
                break;
            default:
                logger.info("WebDriver başlatılıyor: Google Chrome");
                threadDriver.set(new ChromeDriver());
                break;
        }

        logger.debug("Tarayıcı penceresi maksimuma getiriliyor. Sayfa yükleme zaman aşımı: 20 saniye.");
        WebDriver driver = threadDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        logger.info("WebDriver örneği başarıyla oluşturuldu ve yapılandırıldı.");
        return driver;
    }

    /**
     * Aktif WebDriver örneğini sonlandırır ve thread belleğini temizler.
     */
    public static void quitDriver() {
        if (threadDriver.get() != null) {
            try {
                logger.info("WebDriver kapatılıyor. Thread ID: {}", Thread.currentThread().getId());
                threadDriver.get().quit();
            } catch (Exception e) {
                logger.error("WebDriver kapatılırken beklenmeyen bir hata oluştu: {}", e.getMessage());
            } finally {
                threadDriver.remove();
                logger.debug("WebDriver nesnesi ilgili thread'den temizlendi.");
            }
        } else {
            logger.warn("WebDriver kapatılmak istendi ancak aktif bir nesne bulunamadı.");
        }
    }

    /**
     * Çakışmaları önlemek amacıyla çalışan tüm eski ChromeDriver işlemlerini sonlandırır.
     */
    public static void KalanOncekileriKapat() {
        try {
            logger.info("Çakışmaları önlemek için aktif chromedriver işlemleri sonlandırılıyor...");
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            logger.info("Tüm chromedriver işlemleri başarıyla kapatıldı.");
        } catch (Exception e) {
            logger.error("ChromeDriver işlemleri sonlandırılırken hata oluştu: {}", e.getMessage());
        }
    }
}
