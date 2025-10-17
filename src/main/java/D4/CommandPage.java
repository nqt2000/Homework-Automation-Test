package D4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommandPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement menuElement = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        wait.until(ExpectedConditions.elementToBeClickable(menuElement));

        js.executeScript("arguments[0].style.border='3px solid red'", menuElement);
        Thread.sleep(2000);
        menuElement.click();
        Thread.sleep(2000);

        // 1. Refresh
        driver.navigate().refresh();
        Thread.sleep(2000);

        // 2. Back
        WebElement textBox = driver.findElement(By.xpath("//li//span[contains(text(),'Text Box')]"));
        textBox.clear();
        driver.navigate().back();
        Thread.sleep(2000);

        // 3. Forward
        driver.navigate().forward();
        Thread.sleep(2000);

        //4. Get title page or url
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);

        String currentTitle = driver.getTitle();
        System.out.println("Current Title: " + currentTitle);

        // 5. Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://youtube.com/");
        String titleTab1 = driver.getTitle();
        System.out.println("Tab 1 title: " + titleTab1);
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://gmail.com");
        String titleTab2 = driver.getTitle();
        System.out.println("Tab 2 title: " + titleTab2);
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://facebook.com");
        String titleTab3 = driver.getWindowHandle();
        System.out.println("Tab 3 title: " + titleTab3);
        Thread.sleep(2000);

        // 6. Switch to window
        driver.switchTo().window(titleTab3);
        Thread.sleep(2000);

        // 7. Xu li dong tab sau do back lai trang titlePage
        List<String> listTab = driver.getWindowHandles().stream().toList();
        for (int i = 0; i < listTab.size(); i++) {
            driver.switchTo().window(listTab.get(i));
            String title = driver.getTitle();
            if (!"DEMOQA".equals(title)) {
                driver.switchTo().window(listTab.get(i));
                driver.close();
                Thread.sleep(2000);
            }
        }


        driver.quit();
    }
}
