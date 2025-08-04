package internet_HW.testsHW;

import internet_HW.coreHW.TestBaseHW;
import internet_HW.pagesHW.HomePageHW;
import internet_HW.pagesHW.NotificationMessagesHW;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessagesTest extends TestBaseHW {

    @BeforeMethod
    public void preconditionHW(){
        new HomePageHW(driver).getNotificationMessages();
    }

    @Test
    public void notificationMessagesTest(){
        new NotificationMessagesHW(driver)
                .verifyButton("Click here");
        System.out.println("Успешно перешло и нашло Кнопку по Тексту ");
    }
}
