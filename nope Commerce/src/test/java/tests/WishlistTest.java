package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.WishlistPage;

public class WishlistTest extends TestBase {


    ProductDetailsPage productObject;
    WishlistPage wishlistObject;
    String product = "Apple MacBook Pro 13-inch";


    //1-search for product


    //2-add to wishlist
    @Test
    public void UserCanAddProductToWishlist(){
        productObject = new ProductDetailsPage(driver);
        productObject.addToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/" + "/wishlist");
        wishlistObject = new WishlistPage(driver);
        Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
        Assert.assertTrue(wishlistObject.productName.getText().contains(product));
    }


    //3-remove from wishlist
    @Test(priority = 3)
    public void userCanRemoveProductFromWishlist(){
        wishlistObject = new WishlistPage(driver);
        wishlistObject.removeProductFromWishlist();
        Assert.assertTrue(wishlistObject.noDataMessage.getText().contains("The wishlist is empty!"));
    }
}
