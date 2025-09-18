package demoqa.tests;

import demoqa.pages.KeyPressesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyPressesTestHW {
    WebDriver driver;

    @BeforeMethod
    public void superInit() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // не явное

        driver.get("https://the-internet.herokuapp.com/key_presses");
    }

    @Test
    public void typeAndCheck() {
        String a = "Q";
        String b = "You entered: Q";

        new KeyPressesPage(driver)
                .enterSomeSight(a)
                .verifyResult(b);
    }


    @AfterMethod(enabled = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Остановка драйверов после всех тестов
        }
    }


}
