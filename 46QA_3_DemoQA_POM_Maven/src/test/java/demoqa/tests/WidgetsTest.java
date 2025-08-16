package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getWidgest().hideAds();
        new SidePage(driver).selectSelectMenu().hideAds();
    }


    @Test
    public void oldStyleSelectMenuTest(){
        new WidgetsPage(driver)
                .selectOldStyle("Indigo");
    }
}
