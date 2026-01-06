package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        // Initialize ExtentReports
    }

    // @BeforeMethod
    // public void setUp() {
    //     // Set up WebDriver using WebDriverManager
    //     WebDriverManager.chromedriver().setup();
    //     driver = new ChromeDriver();
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //     driver.manage().window().maximize();

    //     // Navigate to base URL from config file
    //     driver.get(ConfigReader.getInstance().getProperty("base.url"));
    // }



    @AfterMethod
    public void tearDown(ITestResult result) {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite() {

    }

}
