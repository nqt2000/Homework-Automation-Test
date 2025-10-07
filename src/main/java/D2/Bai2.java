package D2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        // Button "Double Click Me" bang ID
        WebElement doubleClickBtn1 = driver.findElement(By.id("doubleClickBtn"));
        doubleClickBtn1.click();
        Thread.sleep(2000);

        // Button "Double Click Me" bang CSS
        WebElement doubleClickBtn2 = driver.findElement(By.cssSelector("#doubleClickBtn"));
        doubleClickBtn2.click();
        Thread.sleep(2000);

        // Button "Double Click Me" bang XPath
        WebElement doubleClickBtn3 = driver.findElement(By.xpath("//*[text()=\"Double Click Me\"]"));
        doubleClickBtn3.click();
        Thread.sleep(2000);

        // Button "Click Me"
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Double Click Me']/parent::div/following-sibling::div/button[text()='Click Me']"));
        clickMeBtn.click();
        Thread.sleep(2000);

        // Button "Double Click" partial
        WebElement doubleClickBtn4  = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        doubleClickBtn4.click();
        Thread.sleep(2000);

        WebElement doubleClickBtn5  = driver.findElement(By.xpath("//button[starts-with(text(),'Double')]"));
        doubleClickBtn5.click();
        Thread.sleep(2000);

        driver.close();
    }

}
