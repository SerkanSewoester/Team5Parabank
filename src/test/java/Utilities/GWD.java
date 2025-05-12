package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static final Logger logger = LoggerFactory.getLogger(GWD.class);

    private static WebDriver driver;


    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (driver == null) {
            try {
                logger.info("Yeni WebDriver örneği başlatılıyor: Google Chrome");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                logger.info("WebDriver başarıyla başlatıldı ve yapılandırıldı.");
            } catch (Exception e) {
                logger.error("WebDriver başlatılamadı: {}", e.getMessage(), e);
                throw new RuntimeException("Tarayıcı başlatılamadı.", e);
            }
        }

        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            try {
                logger.info("WebDriver sonlandırılıyor...");
                Thread.sleep(5000);
                driver.quit();
                driver = null;
                logger.info("WebDriver başarıyla kapatıldı.");
            } catch (InterruptedException e) {
                logger.error("Driver kapatma sırasında thread kesintiye uğradı: {}", e.getMessage(), e);
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                logger.error("WebDriver kapatılırken hata oluştu: {}", e.getMessage(), e);
            }
        } else {
            logger.warn("Kapatılacak bir WebDriver örneği bulunamadı.");
        }
    }


    public static void KalanOncekileriKapat() {
        try {
            logger.info("Önceki ChromeDriver işlemleri sonlandırılıyor...");
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            logger.info("ChromeDriver işlemleri başarıyla sonlandırıldı.");
        } catch (Exception e) {
            logger.error("ChromeDriver işlemleri sonlandırılırken hata oluştu: {}", e.getMessage(), e);
        }
    }
}
