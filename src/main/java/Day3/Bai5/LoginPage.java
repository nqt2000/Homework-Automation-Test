package Day3.Bai5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameField = By.id("userName");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login");
    private final By userNameLabel = By.id("userName-value");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) throws InterruptedException {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(user);
        Thread.sleep(2000);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pass);
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(loginButton);

        try {
            loginBtn.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginBtn);
        }
    }

    public boolean isLoginSuccess() {
        try {
            WebElement label = driver.findElement(userNameLabel);
            return label.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
