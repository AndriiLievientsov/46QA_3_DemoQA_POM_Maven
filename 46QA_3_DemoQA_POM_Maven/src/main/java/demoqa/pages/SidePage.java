package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {

    public SidePage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement login;

    public LoginPage selectLogin() {
//        click(login);
        clickWitJS(login, 0, 0);
        return new LoginPage(driver);
    }
}

