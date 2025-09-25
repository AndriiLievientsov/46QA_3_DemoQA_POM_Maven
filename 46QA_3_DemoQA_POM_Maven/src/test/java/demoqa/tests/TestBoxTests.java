package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestBoxTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getElements().hideAds();
        new SidePage(driver).selectTextBox().hideAds();
    }

    @Test
    public void keyboardEventTest() {
        new TextBoxPage(driver)
                .enterPersonalData("Name","email@gmail.com", "address")
                .keyboardEvent()
                .verifyCopyPasteAddress();

        System.out.println("\nВсе успешно Сделал");
    }
}
