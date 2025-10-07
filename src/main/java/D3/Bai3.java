package D3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Bai3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com");
        WebElement choice = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        choice.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//div[@class='header-text' and text()='Alerts, Frame & Windows']"));
        WebElement elementList = header.findElement(By.xpath("(//ancestor::div[contains(@class,'element-group')]//div[contains(@class,'element-list')])[3]"));
        String classAttr = elementList.getAttribute("class");
        assert classAttr != null;
        if (!classAttr.contains("show")) {
            header.click();
        }
        Thread.sleep(2000);

        // ALERT
        WebElement button1 = driver.findElement(By.xpath("(//li[@id='item-1'])[2]"));
        button1.click();
        Thread.sleep(2000);

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        Thread.sleep(2000);
        alert.accept();
        System.out.println("Alert accept.");
        Thread.sleep(2000);

        WebElement timerAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("timerAlertButton")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timerAlertButton);
        System.out.println("Click button and wait 5 second!");
        timerAlertButton.click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert after 5 second: " + alert.getText());
        Thread.sleep(2000);

        alert1.accept();
        System.out.println("Alert accept.");

        // FRAMES
        WebElement button2 = driver.findElement(By.xpath("(//li[@id='item-2'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button2);
        button2.click();
        Thread.sleep(2000);


        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String frameText = heading.getText();
        System.out.print("Text in frame1:");
        System.out.print(frameText);

        js.executeScript("arguments[0].style.border='2px solid blue'; arguments[0].style.backgroundColor='lightyellow';", heading);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.quit();
    }
}
