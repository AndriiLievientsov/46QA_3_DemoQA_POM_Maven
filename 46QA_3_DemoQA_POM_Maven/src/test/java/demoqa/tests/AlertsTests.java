package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getAlertsFrameWindows().hideAds();
        new SidePage(driver).selectAlerts().hideAds();
    }

    @Test
    public void waitAlerts() {
        new AlertsPage(driver)
                .clickAlertWithTimer();
    }

    @Test
    public void alertWithSelected() {
        new AlertsPage(driver)
                .clickOnConfirmButton()
                .selectResult("OK")
                .verifyResult("Ok");
    }

    @Test
    public void sendMessageToAlert() {
        new AlertsPage(driver)
                .clickOnPromptButton()
                .sendTextAlert("Hello")
                .verifyAlertText("Hello");
    }

}
