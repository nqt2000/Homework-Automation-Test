package Day4_5.tests;

import Day4_5.base.BaseTest;
import Day4_5.pages.ElementsPage;
import Day4_5.pages.HomePage;
import Day4_5.pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_TB_001 extends BaseTest {
    @Test
    public void testValidInput() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        homePage.clickElementsMenu();
        elementsPage.openTextBox();

        textBoxPage.fillForm(
                "Nguyen Van A",
                "user@example.com",
                "12 Nguyen Trai, HN",
                "34 Le Loi, HCM"
        );

        //Check output
        Assertions.assertEquals("Name:Nguyen Van A", textBoxPage.getOutputName());
        Assertions.assertEquals("Email:user@example.com", textBoxPage.getOutputEmail());
        Assertions.assertEquals("Current Address :12 Nguyen Trai, HN", textBoxPage.getOutputCurrentAddress());
        Assertions.assertEquals("Permananet Address :34 Le Loi, HCM", textBoxPage.getOutputPermanentAddress());
    }
}
