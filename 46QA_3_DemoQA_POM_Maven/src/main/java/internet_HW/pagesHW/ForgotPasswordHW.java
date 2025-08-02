package internet_HW.pagesHW;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ForgotPasswordHW extends BasePage {

    public ForgotPasswordHW(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id='email']")
    WebElement inputEmail;

    public ForgotPasswordHW enterEmail (String email){
        type(inputEmail, email);
        return this;
    }

    @FindBy (id = "form_submit")
    WebElement clickSubmit;

    public ForgotPasswordHW clickSubmitButton() {
        click(clickSubmit);
        return this;
    }

    @FindBy(xpath = "//h1[normalize-space()='Internal Server Error']")
    WebElement errorMessage;

    public void assertErrorIsVisible() {
        Assert.assertTrue(errorMessage.isDisplayed(), "Сообщение 'Internal Server Error' не отображается");
    }

}
