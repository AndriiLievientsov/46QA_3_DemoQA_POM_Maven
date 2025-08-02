package internet_HW.testsHW;

import internet_HW.coreHW.TestBaseHW;
import internet_HW.pagesHW.FloatingMenuHW;
import internet_HW.pagesHW.HomePageHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest extends TestBaseHW {

    @BeforeMethod
    public void preconditionHW(){
        new HomePageHW(driver).getFloatMenu();
        new HomePageHW(driver).getNotificationMessages();
        new HomePageHW(driver).getForgotPassword();
    }

    @Test
    public void presenceTextTest () {
        new FloatingMenuHW(driver)
                .verifyText("Earum hic optio ipsam");
    }
    //ТЕСТ НЕ ПАШЕТ НАДО ДУМАТЬ ))

}
