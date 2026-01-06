package tests;

//import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
//import utils.ExtentReportManager;

public class DragDropSlidersTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String username = "katrothniroja";
        String accessKey = "LT_xxjDonidZuE4ILQ6qDd3VzcBihyoOd846Hio6zINMI0Gzwv";

        String gridURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        // Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("project", "Selenium 101 Certification");
        ltOptions.put("build", "Drag & Drop Slider Test");
        ltOptions.put("name", "Drag and Drop Slider to 95");
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
public void testDragAndDropSliderTo95() {
    driver.findElement(By.linkText("Drag & Drop Sliders")).click();


    WebElement slider = driver.findElement(By.xpath("//output[@id='rangeSuccess']/preceding-sibling::input[@type='range']"));
    WebElement rangeOutput = driver.findElement(By.id("rangeSuccess"));

    Actions actions = new Actions(driver);
    actions.clickAndHold(slider).moveByOffset(215, 0).release().perform();

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    String actualValue = rangeOutput.getText().trim();
    Assert.assertEquals(actualValue, "95", "Slider value is not 95 as expected.");
}

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
