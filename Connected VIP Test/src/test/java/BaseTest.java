import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseTest {


    @Test
    public void connectedVipTest() throws MalformedURLException {
        AppiumDriver<MobileElement> driver;
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "HUAWEI Y7 Prime 2018");
        cap.setCapability("udid", "26EBB18A11206452");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.0.0");
        cap.setCapability("appPackage", "com.connected.app");
        cap.setCapability("appActivity", "com.connected.app.MainActivity");
        cap.setCapability("unicodeKeyboard", false);
        cap.setCapability("resetKeyboard", false);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement profileIcon = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Tab 5 of 5\"]"));
        profileIcon.click();

        MobileElement requestHelpBtn = driver.findElementByAccessibilityId("Request Help");
        requestHelpBtn.click();

        MobileElement nameEditTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Alert\"]/android.view.View/android.widget.EditText\n"));
        nameEditTxt.click();

        Actions action1 = new Actions(driver);
        action1.sendKeys("ahmed").perform();

        MobileElement confirmBtn = driver.findElementByAccessibilityId("Confirm");
        confirmBtn.click();

        MobileElement passwordEditTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Alert\"]/android.view.View/android.widget.EditText\n"));
        passwordEditTxt.click();

        Actions action2 = new Actions(driver);
        action2.sendKeys("01012345678").perform();

        confirmBtn.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //  System.out.println("wait.......");

        MobileElement requestAcceptedPopUp = driver.findElementByAccessibilityId("Request Received");
        //String text = requestAcceptedPopUp.getText();

//        MobileElement acceptTxt = driver.findElementByAccessibilityId("Your request has been received successfully and one of Connected VIP Assistants will contact you soon");
//        String text = acceptTxt.getText();


        //System.out.println("are u ok?");
        // System.out.println(text);
        Assert.assertTrue(requestAcceptedPopUp.isDisplayed(), "error");

        System.out.println("Accepted Request Message Is Displayed Successfully");

        MobileElement closeBtn = driver.findElementByAccessibilityId("Close");
        closeBtn.click();

        driver.closeApp();


        WebDriverWait wait = new WebDriverWait(driver, 5);
      

    }

//    public static void main(String[] args) {
//        try {
//            connectedVipTest();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
}
