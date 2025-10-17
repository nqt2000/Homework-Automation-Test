package D4.actions;

import D4.locators.LoginLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAction {
    WebDriver driver;
    public void login(String username, String password) throws InterruptedException {
        driver.findElement(By.xpath(LoginLocator.USER_NAME_FIELD)).sendKeys(username);
        driver.findElement(By.xpath(LoginLocator.PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(LoginLocator.LOGIN_BUTTON)).click();
        Thread.sleep(2000);
    }

    public String getText(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
