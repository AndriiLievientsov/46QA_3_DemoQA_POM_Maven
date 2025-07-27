package demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void type (WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
    //метод замена type метода если нужно, добавили возможность опускаться
    // теперь везде где type юзали. можно вот это использовать , но Мне это не понадобилось на Уроке
    protected void typeScrollWithJS (WebElement element, String text, int y) {
        if (text != null) {
            clickWitJS(element, 0,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    //Данный метод юзать если ненаходит элемент и надо скролить страницу.
    protected void clickWitJS(WebElement element, int x, int y) {

        //window.scroll(0,500)
      js.executeScript("window.scrollBy(" + x + ", " + y + ")");
       // js.executeScript("window.scrollBy (({},{})", x,y); //пример другого ситаксиса той команды выше
        click(element);

    }
}
