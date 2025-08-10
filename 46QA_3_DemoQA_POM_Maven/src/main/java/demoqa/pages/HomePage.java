package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
//     click(bookStore);
      clickWitJS(bookStore, 0, 0);
      // тут нули бо я у меня работает. но в целом можно скролить экран задав значение для y - 100 или 500
        return new SidePage(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindows;

    public BasePage getAlertsFrameWindows() {
        click(alertsFrameWindows);
        return new SidePage(driver);
    }
}
