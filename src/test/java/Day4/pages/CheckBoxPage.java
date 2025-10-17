package Day4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CheckBoxPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    Actions actions;

    private final By expandAllButton = By.cssSelector("button[title='Expand all']");
    private final By homeCheckbox = By.xpath("//span[@class='rct-title' and text()='Home']/preceding-sibling::span[@class='rct-checkbox']");
    private final By desktopCheckbox = By.xpath("//span[@class='rct-title' and text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']");
    private final By resultText = By.id("result");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    private void scrollTo(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void expandAll() throws InterruptedException {
        WebElement expand = driver.findElement(expandAllButton);
        scrollTo(expand);
        expand.click();
        Thread.sleep(1000);
    }

    public void selectHome() throws InterruptedException {
        WebElement home = driver.findElement(homeCheckbox);
        scrollTo(home);
        home.click();
        Thread.sleep(1000);
    }

    public void selectDesktop() throws InterruptedException {
        WebElement desktop = driver.findElement(desktopCheckbox);
        scrollTo(desktop);
        desktop.click();
        Thread.sleep(1000);
    }

    public String getResultText() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(resultText).getText();
    }
}
