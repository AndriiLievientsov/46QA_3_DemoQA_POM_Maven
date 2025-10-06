package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPageHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestBoxTestsHW extends TestBase {
    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getElements().hideAds();
        new SidePage(driver).selectTextBoxHW().hideAds();
    }

    @Test
    public void keyboardEventTest() {
        new TextBoxPageHW(driver)
                .enterPersonalData("Anli","aaaaa1@gmail.com", "Dnipro")
                .keyboardEvent()
                .verifyCopyPasteAddress();

        System.out.println("\nВсе успешно Сделал");
    }
}
