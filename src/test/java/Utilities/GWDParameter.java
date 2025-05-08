package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class GWDParameter {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();
    //threadDriver.get()-> bulundugum thread deki driver i al
    // threadDriver.set(driver) -> bulundugum threade driver set et

    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");


        if (threadDriver.get()==null){
            threadBrowserName.set("chrome");
        }
        switch (threadBrowserName.get()) {
            case "edge":
                threadDriver.set(new EdgeDriver());        // bu Thread e bir edge olustur ve set et
            case "firefox":
                threadDriver.set(new FirefoxDriver());  // bu Thread e bir firefox olustur ve set et
            default:
                threadDriver.set(new ChromeDriver());     // bu Thread e bir chrome olustur ve set et

        }
        threadDriver.get().manage().window().maximize(); // bu hattaki driver i max et
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();
    }


    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (threadDriver.get() != null) {

            WebDriver driver = threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }

    public static void KalanOncekileriKapat() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception e) {

        }
    }
}
