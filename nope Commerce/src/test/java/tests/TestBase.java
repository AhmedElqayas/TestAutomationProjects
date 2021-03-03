package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

//    @AfterSuite
//    public void stopDriver() {
//        driver.quit();
//    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result)
//    {
//        if(result.getStatus() == ITestResult.FAILURE)
//        {
//            System.out.println("Failed");
//            System.out.println("Taking screenshot......");
//            Helper.captureScreenShots(driver, result.getName());
//        }
//    }
}
