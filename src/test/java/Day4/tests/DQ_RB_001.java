package Day4.tests;

import Day4.base.BaseTest;
import Day4.pages.ElementsPage;
import Day4.pages.HomePage;
import Day4.pages.RadioButtonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_RB_001 extends BaseTest {
    @Test
    public void testSelectYesRadio() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        homePage.clickElementsMenu();
        elementsPage.openRadioButton();

        radioButtonPage.selectYes();
        String result = radioButtonPage.getResultText();

        Assertions.assertTrue(result.contains("Yes"), "Results do not show 'Yes'");
    }
}
