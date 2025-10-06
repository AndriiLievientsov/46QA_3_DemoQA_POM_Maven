package demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    /* метод что должен прятать рекламу
    *
    * public void hideAds() {
    js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
    js.executeScript("document.getElementById('footer').style.display='none';");
}
    * но так как реклама не успела добавиться сделал вот так
    *
    * public void hideAds() {
        js.executeScript("var ad = document.getElementById('adplus-anchor'); if (ad) ad.style.display='none';");
        js.executeScript("var footer = document.getElementById('footer'); if (footer) footer.style.display='none';");
    }
    * Так ты избежишь ошибки, даже если элемент не найден — скрипт просто ничего не сделает. */


    public void hideAds() {
        js.executeScript("var ad = document.getElementById('adplus-anchor'); if (ad) ad.style.display='none';");
        js.executeScript("var footer = document.getElementById('footer'); if (footer) footer.style.display='none';");
    }


    protected void click(WebElement element) {
        //?Универсальный метод что не скролить постоянно страницу. scrollElement
        // scrollElement(element);
        element.click();
    }

    protected void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    //метод замена type метода если нужно, добавили возможность опускаться
    // теперь везде где type юзали. можно вот это использовать , но Мне это не понадобилось на Уроке
    protected void typeScrollWithJS(WebElement element, String text, int y) {
        if (text != null) {
            clickWitJS(element, 0, y);
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

    protected void scrollTo(int y) {
        js.executeScript("window.scrollBy(0, " + y + ")");
    }

    //Универсальный метод что не скролить постоянно страницу.
    public void scrollElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void shouldHaveText(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
        try {
            // Переменная будет хранить результат ожидания элемента
            boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            Assert.assertTrue(isTextPresent,
                    "Expected text: [" +text+ "] actual text: [" + element.getText() + "] in element: [" + element + "]");
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }


}
