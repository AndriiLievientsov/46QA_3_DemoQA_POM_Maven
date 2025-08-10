package demoqa.tests;

import demoqa.core.TestBase;
import demoqa.pages.BookStorePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTest  extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest () {
        String bookName = "Java";

        new BookStorePage(driver)
                .typeInSearchFieldInput(bookName)
                .verifyText(bookName);
    }

}
