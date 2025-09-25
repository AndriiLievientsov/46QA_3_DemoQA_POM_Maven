package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // тут сделали что бы по прекандишенам пряталась реклама .hideAds()
        new HomePage(driver).getElements().hideAds();
        new SidePage(driver).selectButtons().hideAds();
    }

    @Test
    public void doubleClickButtonsTest() {
        new ButtonsPage(driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");
        System.out.println("\nУспешно");
    }

    @Test
    public void rightClickButtonsTest() throws InterruptedException {
        // throws InterruptedException добавил что бы sleep сработал хотя это и не нужно Мне. Но в случае сдвига страницы
        // типа из за рекламы. это может помочь чуть замедлить выполнение теста. что бы сработало
        new ButtonsPage(driver)
                .rightClickButton()
                .verifyRightClickMessage("You have done a right click");
        System.out.println("\nУспешно");
    }

    //*тест для кнопки с Динамическим локатором
    @Test(invocationCount = 3)
    public void dynamicClickButton() {
        new ButtonsPage(driver)
                .dynamicClickButton()
                .verifyDynamicClickMessage("You have done a dynamic click");
        System.out.println("\nУспешно И Динамично");
    }


    //! Тест от препода на динамический локатор
    @Test(invocationCount = 2)
    public void dynamicClickButtonTest() {
        new ButtonsPage(driver)
                .dynamicClickButtonTest()
                .verivyDynamickMessageTest("You have done a dynamic click");
        System.out.println("Динамично Успешно От Препода");
    }

}
