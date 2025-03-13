package tests;

import config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
