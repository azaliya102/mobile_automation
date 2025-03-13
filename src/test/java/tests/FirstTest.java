package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest extends BaseTest {

    @Test
    public void checkMainWikiPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (int i = 0; i < 3; i++) {
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("org.wikipedia:id/fragment_onboarding_forward_button")
            ));
            continueButton.click();
        }

        try {
            WebElement acceptButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.id("org.wikipedia:id/acceptButton")
            ));
            if (acceptButton.isDisplayed()) {
                acceptButton.click();
            }
        } catch (TimeoutException ignored) {
        }

        Assertions.assertTrue(
                driver.findElement(By.xpath("//android.widget.TextView[@text='Search Wikipedia']")).isDisplayed()
        );

        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Search Wikipedia']")
        ));
        searchField.click();

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']")
        ));
        searchInput.sendKeys("Java");

        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'])[1]")
        ));

        String firstResultText = firstResult.getText();
        Assertions.assertTrue(firstResultText.contains("Java"), "Первый результат не содержит 'Java'");
    }
}
