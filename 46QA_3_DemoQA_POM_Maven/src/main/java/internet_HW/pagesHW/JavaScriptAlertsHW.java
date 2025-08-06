package internet_HW.pagesHW;

import internet_HW.coreHW.BasePageHW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsHW extends BasePageHW {
    public JavaScriptAlertsHW(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[normalize-space()='Click for JS Alert']")
    WebElement buttonJSAlert;

    public JavaScriptAlertsHW clickButtonJSAlert (String expectedText) {
        click(buttonJSAlert);
        assertAlertText(expectedText);
        acceptAlert();
        return this;
    }

    @FindBy (xpath = "//button[normalize-space()='Click for JS Confirm']")
    WebElement buttonJSConfirm;

    public JavaScriptAlertsHW clickButtonJSConfirm (String expectedText) {
        click(buttonJSConfirm);
        assertAlertText(expectedText);
        acceptAlert();
        return this;
    }

    @FindBy (xpath = "//button[normalize-space()='Click for JS Prompt']")
    WebElement buttonJSPrompt;

    public void clickButtonJSPrompt (String expectedText) {
        click(buttonJSPrompt);
        assertAlertText(expectedText);
        acceptAlert();
    }


}
