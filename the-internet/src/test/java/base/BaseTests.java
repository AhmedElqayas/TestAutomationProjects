package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        //Set the executable file of my browser
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //Instantiate a WebDriver object
        driver = new ChromeDriver();

//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        goHome();

        //Handle your application
        homePage = new HomePage(driver);


    }

    @BeforeMethod
    public void goHome() {
        //Launch the application
        driver.get("https://the-internet.herokuapp.com/");
    }


//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//
//    }

}

