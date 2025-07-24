package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "(//div[@class='card mt-4 top-card'])[6]")
    WebElement bookStore;

    public SidePage getBookStore() {
        click(bookStore);
        return  new SidePage(driver);
    }
}
