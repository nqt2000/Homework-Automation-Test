package Day4_5.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class RadioButtonPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    Actions actions;

    private final By yesRadio = By.xpath("//label[@for='yesRadio']");
    private final By resultText = By.className("mt-3");

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    private void scrollTo(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectYes() throws InterruptedException {
        WebElement yes = driver.findElement(yesRadio);
        scrollTo(yes);
        yes.click();
        Thread.sleep(1000);
    }

    public String getResultText() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(resultText).getText();
    }
}
