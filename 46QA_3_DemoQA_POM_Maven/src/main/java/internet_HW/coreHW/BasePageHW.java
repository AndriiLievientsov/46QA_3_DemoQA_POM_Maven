package internet_HW.coreHW;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;



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

    public Alert waitForAlert(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void assertAlertText(String expectedText) {
        Alert alert = waitForAlert(5);
        Assert.assertEquals(alert.getText(), expectedText, "Неверный текст в алерте");
    }

    public void acceptAlert() {
        waitForAlert(5).accept();
    }


}
