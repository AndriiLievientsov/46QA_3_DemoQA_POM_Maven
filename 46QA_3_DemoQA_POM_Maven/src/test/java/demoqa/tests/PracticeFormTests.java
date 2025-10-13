package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms().hideAds();
        new SidePage(driver).selectPracticeForm().hideAds();
    }


    @Test
    public void practiceFormTest() {
        new PracticeFormPage(driver)
                .enterPersonalData(
                        "Beth","Gibbons","portishead@gmail.com", "1234567890")
                .selectGender("Female")
                .chooseDate("4","May","1965")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/Users/Apafios/Desktop/ForProjects/beth.jpg")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");

        System.out.println("Это все успешно сделано");
    }


}
