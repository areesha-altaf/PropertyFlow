package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginObj;
    protected PropertyPage propertyObj;

    @BeforeSuite
    public void setUp() {
        // Set up the WebDriver using WebDriver Manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginObj = new LoginPage(driver); // Initialize objects here
        propertyObj = new PropertyPage(driver);

    }

    @AfterSuite()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @AfterMethod
//    public void addDelay() throws InterruptedException {
//        Thread.sleep(1000);  // 1 second delay after each test to view results on UI
//    }
}
