package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewTest extends TestBase {

    HomePage homeObject;
    UserRegistrationPage registerObject;
    String firstName = "ahmed";
    String lastName = "mohamed";
    String email = "ahmed54@gmail.com";
    String password = "123456";

    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    String searchWord = "mac";
    String productName = "Apple MacBook Pro 13-inch";

    AddReviewPage reviewObject;
    String title = "new review";
    String reviewText = "Good one";
    String result = "Product review is successfully added.";


    @Test(priority = 1)
    public void userCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        registerObject = new UserRegistrationPage(driver);
        homeObject.openRegistrationPage();
        registerObject.userRegistration(firstName, lastName, email, password);
        Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
/*
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(searchWord);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));

        productDetailsObject.openAddReviewPage();
        reviewObject = new AddReviewPage(driver);
        reviewObject.addReview(title, reviewText);
       Assert.assertTrue(reviewObject.reviewResult.getText().contains(result));*/


    }

    @Test(priority = 2)
    public void userCanSearchUsingAutoSuggest(){
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(searchWord);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
    }

    @Test(priority = 3)
    public void userCanAddReview(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.openAddReviewPage();
        reviewObject = new AddReviewPage(driver);
        reviewObject.addReview(title, reviewText);
        Assert.assertTrue(reviewObject.reviewResult.getText().contains(result));
    }

    @Test(priority = 4)
    public void registeredUserCanLogout(){
        registerObject.userLogout();
    }

    @Test(priority = 5)
    public void userCanDoAnything(){

    }

}
