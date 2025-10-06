package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//! Это Моя домашка!
public class TextBoxPageHW extends BasePage {
    public TextBoxPageHW(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Локаторы
    @FindBy (id = "userName")
    WebElement userName;

    @FindBy (id = "userEmail")
    WebElement userEmail;

    @FindBy (id = "currentAddress")
    WebElement currentAddress;

    @FindBy (id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy (id = "submit")
    WebElement submit;


    // 1. Вводим данные
    public TextBoxPageHW enterPersonalData(String name, String email, String address) {
        type (userName, name);
        type (userEmail, email);
        type (currentAddress, address);
        return  this;
    }

    // 2. Копируем Current Address и вставляем в Permanent Address
    public TextBoxPageHW keyboardEvent() {
        // выделяем весь текст в Current Address
        currentAddress.sendKeys(Keys.CONTROL + "a");
        // копируем
        currentAddress.sendKeys(Keys.CONTROL + "c");
        // вставляем в Permanent Address
        permanentAddress.click();
        permanentAddress.sendKeys(Keys.CONTROL + "v");
        click(submit);
        return this;
    }


    /*
    *А вот так это можно было сделать через класс Робот
    public TextBoxPage keyboardEvent() {
    try {
        Robot robot = new Robot();
        robot.setAutoDelay(200); // задержка между действиями

        // 1. Кликаем в поле Current Address
        currentAddress.click();

        // 2. Выделяем весь текст (Ctrl + A)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 3. Копируем (Ctrl + C)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 4. Кликаем в поле Permanent Address
        permanentAddress.click();

        // 5. Вставляем (Ctrl + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // 6. Нажимаем Submit
        click(submit);

    } catch (AWTException e) {
        throw new RuntimeException("Ошибка при работе с Robot: " + e.getMessage());
    }

    return this;
}
*/





    // 3. Проверяем, что текст совпал
    public TextBoxPageHW verifyCopyPasteAddress() {
        String currentText = currentAddress.getAttribute("value");
        String permanentText = permanentAddress.getAttribute("value");

        //*urrentText.split
        //Разбиваем строку по ":". Получаем массив
        //*[1]
        //Берём вторую часть массива — то, что после двоеточия
        //*trim()
        //Убираем пробелы по краям

        if (currentText.contains(":")) {
            currentText = currentText.split(":")[1].trim();
        }
        if (permanentText.contains(":")) {
            permanentText = permanentText.split(":")[1].trim();
        }
        Assert.assertEquals(permanentText, currentText,
                "❌Текст не совпадает! Current: " + currentText + ", Permanent: " + permanentText);

        System.out.println("✅ Текст успешно скопирован и вставлен: " + permanentText);

        return this;
    }
}
