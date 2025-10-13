package Day4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    private final WebDriver driver;
    JavascriptExecutor js;

    private final By fullName = By.id("userName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");

    //Constructor
    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    //Highlight
    private void Scroll(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    //Actions
    public void enterFullname(String name) {
        WebElement element = driver.findElement(fullName);
        Scroll(element);
        element.sendKeys(name);
    }

    public void enterEmail(String mail) {
        WebElement element = driver.findElement(email);
        Scroll(element);
        element.sendKeys(mail);
    }

    public void enterCurrentAddress(String currentaddress) {
        WebElement element = driver.findElement(currentAddress);
        Scroll(element);
        element.sendKeys(currentaddress);
    }

    public void enterPermanentAddress(String permanentaddress) {
        WebElement element = driver.findElement(permanentAddress);
        Scroll(element);
        element.sendKeys(permanentaddress);
    }

    public void clickSubmit() {
        WebElement button = driver.findElement(submit);
        Scroll(button);
        button.click();
    }

    public String getOutputName() {
        return driver.findElement(By.xpath("//p[@id=\"name\"]")).getText();
    }

    public String getOutputEmail() {
        return driver.findElement(By.xpath("//p[@id=\"email\"]")).getText();
    }

    public String getOutputCurrentAddress() {
        return driver.findElement(By.xpath("//p[@id=\"currentAddress\"]")).getText();
    }

    public String getOutputPermanentAddress() {
        return driver.findElement(By.xpath("//p[@id=\"permanentAddress\"]")).getText();
    }

    public void fillForm(String name, String mail, String currentaddress, String permanentaddress) throws InterruptedException {
        enterFullname(name);
        Thread.sleep(2000);
        enterEmail(mail);
        Thread.sleep(2000);
        enterCurrentAddress(currentaddress);
        Thread.sleep(2000);
        enterPermanentAddress(permanentaddress);
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(5000);
    }
}
