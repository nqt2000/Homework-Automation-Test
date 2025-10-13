package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Bai1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com");
        WebElement choice = driver.findElement(By.xpath("//h5[text()='Elements']"));
        choice.click();
        Thread.sleep(2000);

        WebElement elementList = driver.findElement(By.cssSelector(".element-list.collapse"));
        WebElement header = driver.findElement(By.xpath("//div[@class='header-text' and text()='Elements']"));

        String classAttr = elementList.getAttribute("class");
        assert classAttr != null;
        if (!classAttr.contains("show")) {
            header.click();
        }
        Thread.sleep(2000);

        WebElement button0 = driver.findElement(By.id("item-0"));
        button0.click();
        Thread.sleep(2000);

        WebElement fullname = driver.findElement(By.id("userName"));
        js.executeScript("arguments[0].scrollIntoView(true);", fullname);
        fullname.sendKeys("Dao Vinh Mai");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.id("userEmail"));
        js.executeScript("arguments[0].scrollIntoView(true);", email);
        email.sendKeys("mailtest02@gmail.com");
        Thread.sleep(2000);

        WebElement currentaddress = driver.findElement(By.id("currentAddress"));
        js.executeScript("arguments[0].scrollIntoView(true);", currentaddress);
        currentaddress.sendKeys("Khuat Duy Tien, Trung Hoa, Cau Giay, Ha Noi");
        Thread.sleep(2000);

        WebElement permanentaddress = driver.findElement(By.id("permanentAddress"));
        js.executeScript("arguments[0].scrollIntoView(true);", permanentaddress);
        permanentaddress.sendKeys("Nguyen Chi Thanh, Dong Da, Ha Noi");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);


        WebElement resultBox = driver.findElement(By.id("output"));

        js.executeScript("arguments[0].scrollIntoView(true);", resultBox);
        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='yellow';",
                resultBox
        );

        assert resultBox.isDisplayed():"Result not displayed!";

        String resultText = resultBox.getText();
        System.out.println("====== Result ======");
        System.out.println(resultText);

        assert resultText.contains("Dao Vinh Mai") : "Wrong or missing name!";
        assert resultText.contains("mailtest02@gmail.com") : "Wrong or missing email!";
        assert resultText.contains("Khuat Duy Tien, Trung Hoa, Cau Giay, Ha Noi") : "Wrong or missing current address!";
        assert resultText.contains("Nguyen Chi Thanh") : "Wrong or missing permanent address!";

        System.out.println("All assert finish.");

        Thread.sleep(2000);
        driver.quit();
    }
}
