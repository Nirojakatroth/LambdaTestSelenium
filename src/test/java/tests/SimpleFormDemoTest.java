/*
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SimpleFormDemoPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class SimpleFormDemoTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String username = "katrothniroja";
        String accessKey = "LT_xxjDonidZuE4ILQ6qDd3VzcBihyoOd846Hio6zINMI0Gzwv";


        String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        // Desired Capabilities for Firefox
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Firefox");
        capabilities.setCapability("browserVersion", "latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Selenium 101 Certification");
        ltOptions.put("build", "Simple Form Demo Test");
        ltOptions.put("name", "Simple Form Demo - Firefox Test");
        ltOptions.put("selenium_version", "4.0.0");

        // Enable logs
        ltOptions.put("network", true);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("console", true);

        capabilities.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL(gridURL), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
    }

    @Test
    public void testSimpleFormDemo() {

        try {

            driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

            Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"), "URL does not contain 'simple-form-demo'.");

            SimpleFormDemoPage page = new SimpleFormDemoPage(driver);

            String message = "Welcome to LambdaTest";
            page.enterMessage(message);
            page.clickShowMessage();

            String outputMessage = page.getOutputMessage();
            Assert.assertEquals(outputMessage, message, "Message does not match!");
        } catch (Exception e) {
            throw e;
        }
    }
}
*/

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SimpleFormDemoPage;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class SimpleFormDemoTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        String username = "katrothniroja";
        String accessKey = "LT_xxjDonidZuE4ILQ6qDd3VzcBihyoOd846Hio6zINMI0Gzwv";

        FirefoxOptions options = new FirefoxOptions();
        options.setPlatformName("Windows 11");
        options.setBrowserVersion("latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "Selenium 101 Certification");
        ltOptions.put("build", "Simple Form Demo Build");
        ltOptions.put("name", "Simple Form Demo - Firefox");
        ltOptions.put("selenium_version", "4.15.0");
        ltOptions.put("resolution", "1920x1080");

        // Logs
        ltOptions.put("video", true);
        ltOptions.put("console", true);
        ltOptions.put("network", true);

        options.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(
                new URL("https://hub.lambdatest.com/wd/hub"),
                options
        );

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground");
    }

    @Test
    public void testSimpleFormDemo() {

        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("simple-form-demo"),
                "URL does not contain simple-form-demo"
        );

        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);

        String message = "Welcome to LambdaTest";
        page.enterMessage(message);
        page.clickShowMessage();

        Assert.assertEquals(
                page.getOutputMessage(),
                message,
                "Message does not match!"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

