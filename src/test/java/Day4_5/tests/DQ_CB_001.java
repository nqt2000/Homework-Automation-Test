package Day4_5.tests;

import Day4_5.base.BaseTest;
import Day4_5.pages.ElementsPage;
import Day4_5.pages.CheckBoxPage;
import Day4_5.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_CB_001 extends BaseTest {
    @Test
    public void testSelectDesktopNode() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        homePage.clickElementsMenu();
        elementsPage.openCheckBox();

        checkBoxPage.expandAll();
        checkBoxPage.selectDesktop();

        String result = checkBoxPage.getResultText();
        Assertions.assertTrue(result.contains("desktop"), "Not have 'desktop'");
    }
}
