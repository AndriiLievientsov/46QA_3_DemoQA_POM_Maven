package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.devtools.v137.debugger.Debugger.pause;

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
        assert doubleClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClickButton() throws InterruptedException {
        // throws InterruptedException добавил что бы sleep сработал
        Thread.sleep(1000);
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }


    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage verifyRightClickMessage(String text) {
        assert rightClickMessage.getText().equalsIgnoreCase(text);
        return this;
    }


    //!Мой вариант как привязаться к динамичному локатору
    @FindBy (xpath = "(//button[@class='btn btn-primary'])[3]")
    WebElement clickMyButton;
    public ButtonsPage dynamicClickButton() {
        new Actions(driver).click(clickMyButton).perform();
        return this;
    }
    @FindBy (id = "dynamicClickMessage")
    WebElement dynamicClickMessage;
    public void verifyDynamicClickMessage(String textChecker) {
        assert dynamicClickMessage.getText().equalsIgnoreCase(textChecker);

    }

    //! Препод вариант как привязаться к динамичному локатору
    @FindBy (xpath = "//button[.='Click Me']")
    WebElement clickButtonDynamic;
    public ButtonsPage dynamicClickButtonTest() {
        click(clickButtonDynamic);
        return this;
    }
    @FindBy (id = "dynamicClickMessage")
    WebElement dynamicClickMessageTest;
    public ButtonsPage verivyDynamickMessageTest(String s) {
        assert dynamicClickMessageTest.getText().equalsIgnoreCase(s);
        return this;
    }

}
