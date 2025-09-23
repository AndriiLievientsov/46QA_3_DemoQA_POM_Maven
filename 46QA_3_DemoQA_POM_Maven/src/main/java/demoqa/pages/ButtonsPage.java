package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }


    @FindBy (id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClickMessage(String textToFind) {
        shouldHaveText(doubleClickMessage, textToFind, 2000);
        assert doubleClickMessage.getText().contains(textToFind);
        return this;
    }
}
