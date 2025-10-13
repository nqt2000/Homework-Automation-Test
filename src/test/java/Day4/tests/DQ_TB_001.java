package Day4.tests;

import Day4.base.BaseTest;
import Day4.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class DQ_TB_001 extends BaseTest {
    @Test
    public void test() throws InterruptedException {
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(
                "Nguyen Van A",
                "user@example.com",
                "12 Nguyen Trai, HN",
                "34 Le Loi, HCM"
        );
    }
}
