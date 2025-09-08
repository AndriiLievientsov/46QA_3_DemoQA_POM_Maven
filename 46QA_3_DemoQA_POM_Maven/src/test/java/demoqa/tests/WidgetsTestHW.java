package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPageHW;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsTestHW extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets().hideAds();
        new SidePage(driver).selectSelectMenu().hideAds();
    }

    @Test
    public void severalCarSelector() {
        new WidgetsPageHW(driver)
                .multiSelectByText("Volvo", "Saab", "Opel")
                .verifySelected("Volvo", "Saab", "Opel");
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Остановка драйверов после всех тестов
        }
    }

}
