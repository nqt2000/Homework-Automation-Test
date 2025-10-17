package Day4_5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage {
    private WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private void expandElementsIfCollapsed() throws InterruptedException {
        WebElement elementList = driver.findElement(By.cssSelector(".element-list.collapse"));
        WebElement header = driver.findElement(By.xpath("//div[@class='header-text' and text()='Elements']"));
        String classAttr = elementList.getAttribute("class");

        if (!classAttr.contains("show")) {
            header.click();
        }
        Thread.sleep(2000);
    }

    public void openTextBox() throws InterruptedException {
        expandElementsIfCollapsed();
        driver.findElement(By.id("item-0")).click();
        Thread.sleep(2000);
    }

    public void openCheckBox() throws InterruptedException {
        expandElementsIfCollapsed();
        driver.findElement(By.id("item-1")).click();
        Thread.sleep(2000);
    }

    public void openRadioButton() throws InterruptedException {
        expandElementsIfCollapsed();
        driver.findElement(By.id("item-2")).click();
        Thread.sleep(2000);
    }
}
