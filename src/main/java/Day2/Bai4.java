package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        // Locate dung ancestor
        WebElement checkboxIcon = driver.findElement(
                By.xpath("//span[text()='Home']/ancestor::label/span[@class='rct-checkbox']")
        );
        checkboxIcon.click();
        Thread.sleep(3000);

        WebElement homeToggle = driver.findElement(
                By.xpath("//span[text()='Home']/ancestor::span[@class='rct-text']/button")
        );
        homeToggle.click();
        Thread.sleep(3000);

        // Locate nut mui ten cua Documents
        WebElement toggleBtn = driver.findElement(
                By.xpath("//span[text()='Documents']/ancestor::label/preceding-sibling::button")
        );
        toggleBtn.click();
        Thread.sleep(3000);

        // checkbox “Downloads” va di nguoc len
        WebElement downloadsCheckbox = driver.findElement(
                By.xpath("//span[text()='Downloads']/ancestor::label/span[@class='rct-checkbox']")
        );
        downloadsCheckbox.click();
        Thread.sleep(5000);

        driver.quit();
    }
}
