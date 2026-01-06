/*
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class InputFormSubmitPage {
    WebDriver driver;
    private static final Logger logger = Logger.getLogger(InputFormSubmitPage.class.getName());

    By inputFormMenu = By.linkText("Input Form Submit");
    By nameField = By.cssSelector("input[name='name']");
    By emailField = By.id("inputEmail4");
    By passwordField = By.id("inputPassword4");
    By companyField = By.id("company");
    By websiteField = By.id("websitename");
    By countryDropdown = By.cssSelector("select[name='country']");
    By cityField = By.cssSelector("input[name='city']");
    By addressField1 = By.id("inputAddress1");
    By addressField2 = By.id("inputAddress2");
    By stateField = By.id("inputState");
    By zipCodeField = By.id("inputZip");
    By submitButton = By.xpath("//button[text()='Submit']");
    By successMessage = By.xpath("//p[@class='success-msg hidden']");
    By errorField = By.cssSelector("input:invalid");

    public InputFormSubmitPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToForm() {
        logger.info("Navigating to Input Form Submit page...");
        driver.findElement(inputFormMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
    }

    public void fillForm(String name, String email, String password, String company, String website, String country,
                         String city, String address1, String address2, String state, String zipCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("Filling the form with user details...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(websiteField).sendKeys(website);

        WebElement countryElement = driver.findElement(countryDropdown);
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);

        driver.findElement(cityField).sendKeys(city);
        driver.findElement(addressField1).sendKeys(address1);
        driver.findElement(addressField2).sendKeys(address2);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void submitForm() {
        logger.info("Submitting the form...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public boolean isErrorMessageDisplayed() {
        logger.info("Checking for error messages...");
        return driver.findElements(errorField).size() > 0;
    }

    public String getSuccessMessage() {
        logger.info("Fetching the success message...");
        return driver.findElement(successMessage).getText();
    }
}
*/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class InputFormSubmitPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = Logger.getLogger(InputFormSubmitPage.class.getName());

    public InputFormSubmitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By inputFormLink = By.linkText("Input Form Submit");
    private By submitBtn = By.xpath("//button[text()='Submit']");
    private By errorMsg = By.xpath("//input[@required]/following-sibling::div");
    private By successMsg = By.xpath("//p[contains(text(),'Thanks for contacting us')]");

    // Form fields
    private By name = By.id("name");
    private By email = By.id("inputEmail4");
    private By password = By.id("inputPassword4");
    private By company = By.id("company");
    private By website = By.id("websitename");
    private By country = By.name("country");
    private By city = By.id("inputCity");
    private By address1 = By.id("inputAddress1");
    private By address2 = By.id("inputAddress2");
    private By state = By.id("inputState");
    private By zip = By.id("inputZip");

    public void navigateToForm() {
        log.info("Navigating to Input Form Submit page...");
        wait.until(ExpectedConditions.elementToBeClickable(inputFormLink)).click();
    }

    public void submitForm() {
        log.info("Submitting the form...");
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    /*public boolean isErrorMessageDisplayed() {
        log.info("Checking for error message...");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
    }*/

    private By invalidInput = By.cssSelector("input:invalid");

    public boolean isErrorMessageDisplayed() {
        log.info("Checking for invalid input field...");
        return wait.until(ExpectedConditions.presenceOfElementLocated(invalidInput)) != null;
    }


    public void fillForm(
            String nameVal,
            String emailVal,
            String passwordVal,
            String companyVal,
            String websiteVal,
            String countryVal,
            String cityVal,
            String address1Val,
            String address2Val,
            String stateVal,
            String zipVal
    ) {

        log.info("Filling the form...");

        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(nameVal);
        driver.findElement(email).sendKeys(emailVal);
        driver.findElement(password).sendKeys(passwordVal);
        driver.findElement(company).sendKeys(companyVal);
        driver.findElement(website).sendKeys(websiteVal);

        Select selectCountry = new Select(driver.findElement(country));
        selectCountry.selectByVisibleText(countryVal);

        driver.findElement(city).sendKeys(cityVal);
        driver.findElement(address1).sendKeys(address1Val);
        driver.findElement(address2).sendKeys(address2Val);
        driver.findElement(state).sendKeys(stateVal);
        driver.findElement(zip).sendKeys(zipVal);
    }

    public String getSuccessMessage() {
        log.info("Fetching success message...");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }
}

