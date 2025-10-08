package D3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Bai4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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

        WebElement button = driver.findElement(By.xpath("(//li[@id='item-0'])[3]"));
        button.click();
        Thread.sleep(2000);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);

        String parentWindow = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        Thread.sleep(2000);

        WebElement text = driver.findElement(By.id("sampleHeading"));
        js.executeScript("arguments[0].style.border='2px solid red'; arguments[0].style.backgroundColor='yellow';", text);
        System.out.println("Text in new tab: " + text.getText());
        Thread.sleep(2000);

        driver.switchTo().window(parentWindow);

        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(2000);

        driver.quit();

    }
}
