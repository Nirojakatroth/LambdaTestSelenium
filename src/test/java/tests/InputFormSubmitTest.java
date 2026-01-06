package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InputFormSubmitPage;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class InputFormSubmitTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        String username = "katrothniroja";
        String accessKey = "LT_xxjDonidZuE4ILQ6qDd3VzcBihyoOd846Hio6zINMI0Gzwv";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "Selenium 101 Certification");
        ltOptions.put("build", "InputFormSubmitTest-Build");
        ltOptions.put("name", "Input Form Submit Test");
        ltOptions.put("selenium_version", "4.15.0");
        ltOptions.put("resolution", "1920x1080");
        ltOptions.put("video", true);
        ltOptions.put("console", true);
        ltOptions.put("network", true);

        browserOptions.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://hub.lambdatest.com/wd/hub"),
                browserOptions
        );

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground");
    }

    @Test
    public void testInputFormSubmit() {

        InputFormSubmitPage page = new InputFormSubmitPage(driver);

        // Navigate & submit empty form
        page.navigateToForm();
        page.submitForm();

        Assert.assertTrue(
                page.isErrorMessageDisplayed(),
                "Error message NOT displayed for empty form"
        );

        // Fill form
        page.fillForm(
                "Niroja",
                "katrothniroja@gmail.com",
                "Niroja@9495",
                "QualiZeal",
                "https://qualizeal.com",
                "India",
                "Hyderabad",
                "123 ABC",
                "CDE 456",
                "Telangana",
                "500072"
        );

        page.submitForm();

        // Verify success
        Assert.assertTrue(
                page.getSuccessMessage()
                        .contains("Thanks for contacting us"),
                "Success message NOT displayed"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


