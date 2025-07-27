package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    /*
    First name: Anli
    Last name: Leo
    UserName: AnliTest
    Password: Parazit102@
     */

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePage(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .enterPersonalData("AnliTest", "Parazit102@")
                .clickLoginButton()
                .verifyUserName("AnliTest");

    }

}
