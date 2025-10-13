package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");

        // Locate bang LinkText
        WebElement homeLink1 = driver.findElement(By.linkText("Home"));
        homeLink1.click();
        Thread.sleep(3000);


        // Locate bang PartialLinkText
        WebElement homeLink2 = driver.findElement(By.partialLinkText("Ho"));
        homeLink2.click();
        Thread.sleep(3000);

        // Locate bang XPath
        WebElement movedLink = driver.findElement(By.xpath("//a[text()='Moved']"));
        movedLink.click();

        // Locate bang following-sibling
        WebElement nextLink = driver.findElement(By.xpath("(//a[text()='Home']/parent::p//following-sibling::p/a)[1]"));
        nextLink.click();
        Thread.sleep(5000);


        driver.quit();
    }
}
