package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="strong.current-item")
    public WebElement productNameBreadCrumb;

    @FindBy(css="input.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    public void openEmailFriendPage(){
        clickButton(emailFriendBtn);
    }

    @FindBy(id = "price-value-4")
    public WebElement currencyLabel;

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    public void openAddReviewPage(){
        clickButton(addReviewLink);
    }

    @FindBy(id ="add-to-wishlist-button-4")
    WebElement addToWishlistBtn;

    public void addToWishList(){
        clickButton(addToWishlistBtn);
    }

    @FindBy(css = "input.button-2.add-to-compare-list-button")
    WebElement addToCompareBtn;

    public void addToCompare(){
        clickButton(addToCompareBtn);
    }

}
