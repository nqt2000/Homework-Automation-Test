package D3.Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bai5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        WebElement choice = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
        Thread.sleep(2000);
        choice.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//div[@class='header-text' and text()='Book Store Application']"));
        WebElement elementList = header.findElement(By.xpath("(//ancestor::div[contains(@class,'element-group')]//div[contains(@class,'element-list')])[6]"));
        String classAttr = elementList.getAttribute("class");
        assert classAttr != null;
        if (!classAttr.contains("show")) {
            header.click();
        }
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.xpath("(//li[@id='item-0'])[6]"));
        button.click();
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("testuser", "Test@1234");
        Thread.sleep(10000);

        if (loginPage.isLoginSuccess()) {
            System.out.println("Login Success!");
        } else {
            System.out.println("Login Fail!");
        }

        System.out.println("Title after login: " + driver.getTitle());

        driver.quit();
    }
}
