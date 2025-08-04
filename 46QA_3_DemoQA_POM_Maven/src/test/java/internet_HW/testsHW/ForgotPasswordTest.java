package internet_HW.testsHW;

import internet_HW.coreHW.TestBaseHW;
import internet_HW.pagesHW.ForgotPasswordHW;
import internet_HW.pagesHW.HomePageHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBaseHW {

    @BeforeMethod
    public void preconditionHW() {
        new HomePageHW(driver).getForgotPassword();
    }

    @Test
    public void emailEnterTest() {
        new ForgotPasswordHW(driver)
                .enterEmail("random@gmail.com")
                .clickSubmitButton()
                .assertErrorIsVisible();
        System.out.println("Тест с эмейлом и эррором пройдет");

    }
}
