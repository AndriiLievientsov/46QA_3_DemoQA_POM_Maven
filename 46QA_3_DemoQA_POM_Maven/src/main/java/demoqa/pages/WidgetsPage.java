package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

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
        shouldHaveText(oldSelectMenu, color, 5000);
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

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }


        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        System.out.println("\nВыбрано: " + selectedText);
//        System.out.println("\nВыбрано: " + select.getOptions().get(index).getText());

        return this;
    }

    public  WidgetsPage verifyByIndex (int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;

        //* проходим по всем выбранным элементам списка

        for (WebElement option : selectedOptions) {
            if (option.getText().equals(selectedText)) {
                textFound = true;
                break;
            }
        }
        System.out.println("\nСверено: " + selectedText);
        Assert.assertTrue(textFound);

        return this;
    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select= new Select(cars);
        if (select.isMultiple()) {
            for (String element : car){
                select.selectByVisibleText(element);
            }

        }
        return this;
    }


    //Надо бы разобраться с этим кодом. Вроде понятно. но надо еще подумать
    public WidgetsPage verifyMultiSelectByCars(String[] expected) {
        //? Создаем обьект Select для элемента cars
        Select select = new Select(cars);

        //? Получаем все опции для выбранных уже на этом этапе элементов в списке
        List<WebElement> selectedOptions = select.getAllSelectedOptions();

        //? Хранит список выбранных автомобилей в данный момент в списке
        List <String> selectedText = new ArrayList<>();

        //? Проходит по списку и каждый выбранный элемент сохраняем в массив как новая строка
        for (WebElement option : selectedOptions) {
            selectedText.add(option.getText());
        }

        //? Автомобили которые мы передаем для сравнения (ожидаемые)
        List<String> expectedText = Arrays.asList(expected);

        //? Используем HashSet потому что:
        //? не нужен доступ к элементам множества по их индексу
        //? автоматом удаляются дубликаты
        //? хэшируется множество, что ускоряет поиск
        //? порядок элементов не важен в нашем сценарии
        //? метод containsAll сделает за нас все сравнения даже без циклов каких либо
        assert new HashSet<>(selectedText).containsAll(expectedText);


        return this;
    }
}
