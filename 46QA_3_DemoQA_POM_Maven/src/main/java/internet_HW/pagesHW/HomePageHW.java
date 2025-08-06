package internet_HW.pagesHW;

import internet_HW.coreHW.BasePageHW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHW extends BasePageHW {

    public HomePageHW(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/floating_menu']")
    WebElement floatMenu;

    public FloatingMenuHW getFloatMenu() {
        click(floatMenu);
        return new FloatingMenuHW (driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Notification Messages']")
    WebElement notificationMessages;

    public NotificationMessagesHW getNotificationMessages(){
        click(notificationMessages);
        return new NotificationMessagesHW (driver);
    }

    @FindBy (xpath = "//a[normalize-space()='Forgot Password']")
    WebElement forgotPassword;

    public ForgotPasswordHW getForgotPassword() {
        click(forgotPassword);
        return new ForgotPasswordHW(driver);
    }

    @FindBy (xpath = "//a[normalize-space()='JavaScript Alerts']")
    WebElement javaScriptAlerts;

    public JavaScriptAlertsHW getJavaScriptAlerts () {
        click(javaScriptAlerts);
        return new JavaScriptAlertsHW (driver);
    }

}
