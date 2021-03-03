package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

    HomePage homeObject;
    ContactUsPage contactUsObject;
    String name="ahmed";
    String email="ahmed@gmail.com";
    String message = "hello world";
    String submitResult = "Your enquiry has been successfully sent to the store owner.";

    @Test
    public void userCanContactUs(){
        homeObject = new HomePage(driver);
        contactUsObject = new ContactUsPage(driver);

        homeObject.openContactUsPage();
        contactUsObject.contactUs(name, email, message);

        Assert.assertTrue(contactUsObject.submitResult.getText().contains(submitResult));
    }
}
