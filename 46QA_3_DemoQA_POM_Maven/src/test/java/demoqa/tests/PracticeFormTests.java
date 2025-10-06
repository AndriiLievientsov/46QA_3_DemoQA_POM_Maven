package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
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
                .enterPersonalData()
                .selectGender()
                .chooseDate()
                .enterSubject()
                .chooseHobbies()

    }
}
