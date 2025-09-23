package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {

    public SidePage(WebDriver driver) {

        super(driver);
    }

    //*Login
    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement login;

    public LoginPage selectLogin() {
//        click(login);
        clickWitJS(login, 0, 0);
        return new LoginPage(driver);
    }

    //*Alerts
    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    //*SelectMenu
    @FindBy(xpath = " //span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage selectSelectMenu() {
        click(selectMenu);
        return new WidgetsPage(driver);
    }


    //*BrowserWindows
    @FindBy(xpath = " //span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }

    //* SelectButtons

    @FindBy(xpath = " //span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }

}

