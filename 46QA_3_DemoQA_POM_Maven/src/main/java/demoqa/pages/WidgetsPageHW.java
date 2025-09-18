package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetsPageHW extends BasePage {

    public WidgetsPageHW(WebDriver driver) {
        super(driver);
    }

    public WidgetsPageHW multiSelectByText(String... texts) {
        WebElement cars = driver.findElement(By.id("cars"));

        Select select = new Select(cars);
        for (String text : texts) {
            select.selectByVisibleText(text);
        }
        return this;
    }

    public WidgetsPageHW verifySelected(String... expectedValues) {
        WebElement cars = driver.findElement(By.id("cars"));
        Select select = new Select(cars);

        //*Это список WebElement-ов, а не строк.
        List<WebElement> selectedOptions = select.getAllSelectedOptions();


        //*Ты создаёшь пустой список строк, чтобы потом туда
        //*положить текстовое представление каждого выбранного элемента.

        List<String> selectedTexts = new ArrayList<>();

        //*Зачем это нужно?
        //*Потому что ты хочешь сравнивать выбранные значения с ожидаемыми:
        //*- selectedOptions — это WebElement-ы
        //*- expectedValues — это строки ("Volvo", "Saab")
        //*Чтобы сравнивать их, тебе нужно превратить WebElement → String, и ты делаешь это вручную:

        for (WebElement option : selectedOptions) {
            selectedTexts.add(option.getText());
        }

        for (String expected : expectedValues) {
            boolean found = false;
            for (String selected : selectedTexts) {
                if (selected.equals(expected)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue(found, "❌ Значение '" + expected + "' не выбрано. Выбраны: " + selectedTexts);
        }

        System.out.println("✅ Успешно выбраны: " + selectedTexts);
        return this;
    }


}
