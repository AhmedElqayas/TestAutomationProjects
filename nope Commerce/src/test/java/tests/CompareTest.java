package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.ProductDetailsPage;

public class CompareTest extends TestBase {

    ProductDetailsPage productObject;
    ComparePage compareObject;

    String product1 = "";
    String product2= "";

    @Test
    public void userCanCompare (){
        //1-search for the first product
        productObject = new ProductDetailsPage(driver);
        productObject.addToCompare();

        //2-search for the second product
        productObject.addToCompare();
        try {
            Thread.sleep(1000); //wait until the second product to be added
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().to("https://demo.nopcommerce.com" + "/compareproducts");
        compareObject = new ComparePage(driver);
        Assert.assertTrue(compareObject.firstProductName.getText().contains(product1));
        Assert.assertTrue(compareObject.secondProductName.getText().contains(product2));

        compareObject.compareProducts();



    }
}
