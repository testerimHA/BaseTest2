package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();
    private static final ThreadLocal<Browsers> browsers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver(browsers.get());
    }

    public static WebDriver getDriver(Browsers browser) {

        if(browsers.get()==null){
            browsers.set(browser);}

        if (drivers.get() == null){
            switch (browser){
                case CHROME:
                    drivers.set(DriverFactory.createChrome());
                    break;
                case FIREFOX:
                    drivers.set(DriverFactory.createFirefox());
                    break;
            }
        }

        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(25)));
        WebDriver webDriver = drivers.get();
        return webDriver;
    }

    public static WebDriverWait getWait() {
        return waits.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
            waits.set(null);
        }
    }
}
