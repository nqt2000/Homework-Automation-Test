package D3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Bai2 {
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

        // CHECKBOX
        WebElement button1 = driver.findElement(By.id("item-1"));
        button1.click();
        Thread.sleep(2000);

        WebElement expandAll = driver.findElement(By.cssSelector("button[title='Expand all']"));
        expandAll.click();
        Thread.sleep(2000);

        WebElement commandsLabel = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Commands']"));

        try {
            commandsLabel.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", commandsLabel);
        }

        Thread.sleep(2000);

        WebElement resultBox = driver.findElement(By.id("result"));
        js.executeScript("arguments[0].scrollIntoView(true);", resultBox);
        js.executeScript("arguments[0].style.border='2px solid red'; arguments[0].style.backgroundColor='yellow';", resultBox);
        Thread.sleep(2000);

        System.out.println("===== Result Checkbox =====");
        System.out.println(resultBox.getText());

        if (resultBox.getText().contains("commands")) {
            System.out.println("Success! 'Commands' selected.");
        } else {
            System.out.println("Failed to select 'Commands'!");
        }
        Thread.sleep(2000);

        // RADIO BUTTON
        WebElement button2 = driver.findElement(By.id("item-2"));
        button2.click();
        Thread.sleep(2000);

        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        try {
            yesLabel.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", yesLabel);
        }

        Thread.sleep(2000);
        WebElement resultText = driver.findElement(By.className("text-success"));
        System.out.println("Result choose 'Yes': " + resultText.getText());
        if (resultText.getText().equalsIgnoreCase("Yes")) {
            System.out.println("'Yes' chosen!");
        }

        Thread.sleep(2000);

        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        try {
            impressiveLabel.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", impressiveLabel);
        }

        Thread.sleep(2000);
        resultText = driver.findElement(By.className("text-success"));
        System.out.println("Result choose 'Impressive': " + resultText.getText());
        if (resultText.getText().equalsIgnoreCase("Impressive")) {
            System.out.println("'Impressive' chosen!");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
