package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import demoqa.pages.WidgetsPageHW;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class WidgetsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getWidgets().hideAds();
        new SidePage(driver).selectSelectMenu().hideAds();
    }


    @Test
    public void oldStyleSelectMenuTest() {
        new WidgetsPage(driver).selectOldStyle("Indigo");
    }

    @Test
    public void multiSelect() {
        String[] colorsSelect = {"Green", "Blue"};
        new WidgetsPage(driver).multiSelect(colorsSelect);
        assertTrue(new WidgetsPage(driver).areColorsSelected(colorsSelect));
    }

    //! Вот этот тест. Пример того что я делал в WidgetsTestHW это версия Препода
    //? для одного
    @Test
    public void standardMultiSelectByIndexTest() {
        new WidgetsPage(driver)
                .standardMultiSelectByIndex(2)
                .verifyByIndex(2);
    }

    //? для нескольких машин
    @Test
    public void standardMultiSelectByCarsTest() {
        String[] car = {"Volvo", "Opel", "Saab"};
        new WidgetsPage(driver)
                .standardMultiSelectByCars(car)
                .verifyMultiSelectByCars(car);


    }

}
