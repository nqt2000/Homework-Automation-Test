package Day4.tests;

import Day4.base.BaseTest;
import Day4.pages.ElementsPage;
import Day4.pages.CheckBoxPage;
import Day4.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_CB_002 extends BaseTest {
    @Test
    public void testSelectHomeCascade() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        homePage.clickElementsMenu();
        elementsPage.openCheckBox();

        checkBoxPage.expandAll();
        checkBoxPage.selectHome();

        String result = checkBoxPage.getResultText();
        Assertions.assertTrue(result.contains("desktop"), "Result not have desktop");
        Assertions.assertTrue(result.contains("documents"), "Result not have documents");
        Assertions.assertTrue(result.contains("downloads"), "Result not have downloads");
    }
}
