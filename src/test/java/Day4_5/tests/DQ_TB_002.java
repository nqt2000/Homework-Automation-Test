package Day4_5.tests;

import Day4_5.base.BaseTest;
import Day4_5.pages.ElementsPage;
import Day4_5.pages.HomePage;
import Day4_5.pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_TB_002 extends BaseTest {
    @Test
    public void testInvalidEmail() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        homePage.clickElementsMenu();
        elementsPage.openTextBox();

        textBoxPage.fillForm(
                "Nguyen Van A",
                "user@",
                "12 Nguyen Trai, HN",
                "34 Le Loi, HCM"
        );

        //Check output
        Assertions.assertTrue(textBoxPage.isEmailBorderRed(), "Email border is not red!");

        // Check output or email visible
        Assertions.assertFalse(textBoxPage.isOutputVisible() && textBoxPage.isOutputEmailVisible(),
                "Output or email is display wrong email!");

    }
}
