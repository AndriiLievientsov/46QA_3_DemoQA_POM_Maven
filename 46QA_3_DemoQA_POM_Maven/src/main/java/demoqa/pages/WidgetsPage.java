package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    //*SelectMenu
    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        shouldHaveText(oldSelectMenu,color,5000);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;


//    @FindBy (css = "html")
//    WebElement space; // имитация нажатия где то на странице

    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {
            if (colors != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
//            click(space); //жмется что бы выйти из выпадающего списка выбора цветов
            inputSelect.sendKeys(Keys.ESCAPE); // так же само чтоб выйти из листа выбора
        }

        return this;
    }


    @FindBy(css = ".css-12jo7m5")
    List<WebElement> selectedColorsElements;

    public boolean areColorsSelected(String[] colors) {

        List<String> selectedText = new ArrayList<>();

        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());
        }

        for (String color : colors) {
            if (!selectedText.contains(color)) {
                return false;

            }
        }

        return true;
    }
}
