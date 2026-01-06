/*
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleFormDemoPage {
    WebDriver driver;

    By messageInput = By.id("user-message");
    By showMessageButton = By.id("showInput");
    By outputMessage = By.id("message");

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickShowMessage() {
        driver.findElement(showMessageButton).click();
    }

    public String getOutputMessage() {
        return driver.findElement(outputMessage).getText();
    }
}
*/
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormDemoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By messageInput = By.id("user-message");
    private By showMessageButton = By.id("showInput");
    private By outputMessage = By.id("message");

    // Actions
    public void enterMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput))
                .clear();
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickShowMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(showMessageButton))
                .click();
    }

    public String getOutputMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputMessage))
                .getText();
    }
}
