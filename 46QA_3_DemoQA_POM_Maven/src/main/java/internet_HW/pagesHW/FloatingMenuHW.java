package internet_HW.pagesHW;

import internet_HW.coreHW.BasePageHW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuHW extends BasePageHW {

    public FloatingMenuHW(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//p[contains(text(),'Sit non unde maiores cum laudantium ab inventore m')]")
//    WebElement textChecker;

    @FindBy(xpath = "//p[contains(text(),'Earum hic optio ipsam quis impedit omnis quos ipsa')]")
    WebElement textChecker;

    public FloatingMenuHW verifyText (String text) {
        assert textChecker.getText().contains(text);
        return this;
    }

}
