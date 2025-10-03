import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        // Locate bang id radio
        WebElement yesRadio = driver.findElement(By.xpath("//input[@id='yesRadio']/following-sibling::label"));
        yesRadio.click();
        Thread.sleep(2000);

        // Locate bang id label
        WebElement yesRadio2 = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesRadio2.click();
        Thread.sleep(2000);

        // Locate bang css
        WebElement yesLabel = driver.findElement(By.cssSelector("#yesRadio + label"));
        yesLabel.click();
        Thread.sleep(2000);

        // text label “Impressive”
        WebElement impressiveInput = driver.findElement(
                By.xpath("//label[text()='Impressive']/ancestor::div[@class='custom-control custom-radio custom-control-inline']/input")
        );
        impressiveInput.click();

        driver.quit();
    }
}
