package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class MyAccountTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    ChangePasswordPage changePasswordObject;
    LoginPage loginObject;

    String firstName = "ahmed";
    String lastName = "mohamed";
    String email = "ahmed46@gmail.com";
    String password = "123456";
    String newPassword = "1234567899";

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registerObject.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void userCanChangePassword() {
        registerObject.openMyAccountPage();
        myAccountObject = new MyAccountPage(driver);
        myAccountObject.openChangePasswordPage();
        changePasswordObject = new ChangePasswordPage(driver);
        changePasswordObject.changePassword(password, newPassword);
        Assert.assertTrue(changePasswordObject.changePasswordResult.getText().contains("Password was changed"));

    }

    @Test(priority = 3)
    public void registeredUserCanLogout() {
        //registerObject.userLogout();
        changePasswordObject = new ChangePasswordPage(driver);
        changePasswordObject.logoutFromChangePasswordPage();

    }

  @Test(dependsOnMethods = ("registeredUserCanLogout"))
    public void registeredUserCanLogin() {
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email, newPassword);
        Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
    }
}
