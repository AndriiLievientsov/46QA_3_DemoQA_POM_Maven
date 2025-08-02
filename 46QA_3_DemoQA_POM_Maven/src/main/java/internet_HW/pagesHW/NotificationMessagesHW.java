package internet_HW.pagesHW;

import internet_HW.coreHW.BasePageHW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagesHW extends BasePageHW {
    public NotificationMessagesHW(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Click here")
    WebElement clickHereButton;

    public NotificationMessagesHW verifyButton(String text) {
        assert clickHereButton.getText().contains(text);
        return this;
    }
}
