package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase{

    String searchWord = "mac";
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;

    @Test
    public void userCanSearchUsingAutoSuggest(){
        searchObject = new SearchPage(driver);
        searchObject.productSearchUsingAutoSuggest(searchWord);
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
    }
}
