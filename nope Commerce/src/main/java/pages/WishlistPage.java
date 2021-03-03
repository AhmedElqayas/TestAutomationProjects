package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1")
    public WebElement wishlistHeader;

    @FindBy(css = "a.product-name")
    public WebElement productName;

    @FindBy(css = "removefromcart")
    WebElement removeFromBtn;

    @FindBy(css = "updatecart")
    WebElement updateCartBtn;

    @FindBy(css="div.no-data")
    public WebElement noDataMessage;

    public void removeProductFromWishlist(){
        clickButton(removeFromBtn);
        clickButton(updateCartBtn);
    }
}
