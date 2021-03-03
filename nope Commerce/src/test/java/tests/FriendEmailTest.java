package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FriendEmailTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    String firstName = "ahmed";
    String lastName = "mohamed";
    String email = "ahmed41@gmail.com";
    String password = "123456";

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    String searchWord = "mac";
    String productName = "Apple MacBook Pro 13-inch";

    EmailFriendPage emailFriendObject;
    String friendEmail = "tamer@gmail.com";
    String message = "hello friend";
    String successMessage = "Your message has been sent.";




    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registerObject.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

    }

    @Test(priority = 2)
    public void userCanSearchUsingAutoSuggest(){
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(searchWord);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
    }

    @Test(priority = 3)
    public void userCanSendFriendEmail(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.openEmailFriendPage();
        emailFriendObject = new EmailFriendPage(driver);
        emailFriendObject.sendEmail(friendEmail, message);
        Assert.assertTrue(emailFriendObject.sendEmailResult.getText().contains(successMessage));

    }


}
