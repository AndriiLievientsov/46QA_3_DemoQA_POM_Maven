package internet_HW.testsHW;

import internet_HW.coreHW.TestBaseHW;
import internet_HW.pagesHW.FloatingMenuHW;
import internet_HW.pagesHW.HomePageHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenuPageTest extends TestBaseHW {

    @BeforeMethod
    public void preconditionHW() {
        new HomePageHW(driver).getFloatMenu();

    }

    @Test
    public void presenceTextTest() {
        new FloatingMenuHW(driver)
                .classChecker();
        System.out.println("Класс Успешной найден ");
    }
}