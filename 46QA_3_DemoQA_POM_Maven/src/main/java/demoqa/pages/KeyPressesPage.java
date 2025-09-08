package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.lang.reflect.Field;

public class KeyPressesPage extends BasePage {
    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "target")
    WebElement target;

    @FindBy(id = "result")
    WebElement result;

    public KeyPressesPage enterSomeSight(String text) {
        type(target, text);
        return this;
    }

    public KeyPressesPage verifyResult(String expectedText) {
        String actualText = result.getText();
        Assert.assertEquals(actualText, expectedText, "Неверный текст в блоке result");
        System.out.println("Фактический текст на странице: " + actualText + "\nОжидаемый текст: " + expectedText);
        return this;
    }





}
