package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {

    HomePage homeObject;

    String searchWord = "mac";
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    String label = "€";

    @Test(priority = 1)
    public void userCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
    }

    @Test(priority = 2)
    public void userCanSearchUsingAutoSuggest(){
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(searchWord);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(productDetailsObject.currencyLabel.getText().contains(label));
    }




}
