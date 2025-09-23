package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getElements().hideAds();
        new SidePage(driver).selectButtons().hideAds();
    }

    @Test
    public void doubleClickButtonsTest () {
        new ButtonsPage(driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");
        System.out.println("\nУспешно");
    }



}
