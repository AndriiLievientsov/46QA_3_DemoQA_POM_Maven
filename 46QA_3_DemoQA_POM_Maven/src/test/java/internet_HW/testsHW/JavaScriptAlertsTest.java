package internet_HW.testsHW;

import internet_HW.coreHW.TestBaseHW;
import internet_HW.pagesHW.HomePageHW;
import internet_HW.pagesHW.JavaScriptAlertsHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends TestBaseHW {

    @BeforeMethod
    public void preconditionHW() {
        new HomePageHW(driver).getJavaScriptAlerts();
    }

    @Test
    public void javaScriptAlertsTest () {
        new JavaScriptAlertsHW(driver)
                .clickButtonJSAlert("I am a JS Alert")
                .clickButtonJSConfirm("I am a JS Confirm")
                .clickButtonJSPrompt("I am a JS prompt");
        System.out.println("Алерты протыкны");
    }

}
