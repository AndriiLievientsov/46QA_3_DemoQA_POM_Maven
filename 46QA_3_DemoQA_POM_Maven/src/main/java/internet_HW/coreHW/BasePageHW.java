package internet_HW.coreHW;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static java.awt.SystemColor.text;

public class BasePageHW {

    public WebDriver driver;
    JavascriptExecutor js;

    public BasePageHW (WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void click (WebElement element) {
        element.click();
    }

    public void type (WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }



}
