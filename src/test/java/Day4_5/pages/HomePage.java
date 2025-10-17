package Day4_5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementsMenu() throws InterruptedException {
        WebElement choice = driver.findElement(By.xpath("//h5[text()='Elements']"));
        choice.click();
        Thread.sleep(2000);
    }
}
