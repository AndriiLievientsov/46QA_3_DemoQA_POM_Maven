package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

//? Работа преподавателя
public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    // userName
    // userEmail
    // currentAddress
    // permanentAddress
    // submit


    @FindBy (id = "userName")
    WebElement userName;

    @FindBy (id = "userEmail")
    WebElement userEmail;

    @FindBy (id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage enterPersonalData(String name, String email, String address) {
        type (userName, name);
        type (userEmail, email);
        type (currentAddress, address);
        return this;
    }

    public TextBoxPage keyboardEvent() throws AWTException {
        Robot robot = new Robot();
        //Ctrl + A
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Ctrl + C
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        //Ctrl + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        //Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        //Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        return this;

    }

    @FindBy (css = "p#currentAddress")
    WebElement currentAddressResult;

    @FindBy (css = "p#permanentAddress")
    WebElement permanentAddressResult;


    public TextBoxPage verifyCopyPasteAddress() {

        String [] current = currentAddressResult.getText().split(":");
        String [] permanent = permanentAddressResult.getText().split(":");
        System.out.println(current[1].trim());
        System.out.println(permanent[1].trim());
        Assert.assertEquals(current[1].trim(), permanent[1].trim());

        return this;
    }
}
