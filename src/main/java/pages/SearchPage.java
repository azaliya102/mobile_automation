package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private By searchInput = By.id("org.wikipedia:id/search_src_text");
    private By firstResult = By.xpath("(//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'])[1]");

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void searchFor(String query) {
        type(searchInput, query);
    }

    public String getFirstResult() {
        return getText(firstResult);
    }
}
