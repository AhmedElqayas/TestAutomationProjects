package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    String email = "ahmedmohamed22@gmail.com";
    String password ="123456789";

    @Test(priority = 1, alwaysRun = true)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registerObject.userRegistration("ahmed", "mohamed", email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = ("userCanRegisterSuccessfully"))
    public void registeredUserCanLogout(){
        registerObject.userLogout();
    }

    @Test(dependsOnMethods = ("registeredUserCanLogout"))
    public void registeredUserCanLogin(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, password);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));

    }
}
