package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setDeviceName("Pixel_2_API_27");
                options.setAutomationName("uiautomator2");
                options.setApp(System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia_50460_apps.evozi.com.apk");
                options.setAppPackage("org.wikipedia");
                options.setAppActivity("org.wikipedia.main.MainActivity");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            } catch (MalformedURLException e) {
                throw new RuntimeException("Ошибка в URL Appium Server", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
