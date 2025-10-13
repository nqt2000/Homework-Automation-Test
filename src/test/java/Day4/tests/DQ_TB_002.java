package Day4.tests;

import Day4.base.BaseTest;
import Day4.pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DQ_TB_002 extends BaseTest {
    @Test
    public void test() throws InterruptedException {
        TextBoxPage textBoxPage = new TextBoxPage(driver);

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
