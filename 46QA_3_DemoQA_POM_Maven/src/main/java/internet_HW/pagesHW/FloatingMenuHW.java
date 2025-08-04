package internet_HW.pagesHW;

import internet_HW.coreHW.BasePageHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FloatingMenuHW extends BasePageHW {

    public FloatingMenuHW(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(.,'Earum hic optio ipsam')]")
    WebElement textChecker;

    @FindBy(className = "row")
    WebElement classFinder;

    public FloatingMenuHW classChecker() {
        assert classFinder.isDisplayed();
        return this;
    }


}
