package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewText;

    @FindBy(id = "addproductrating_4")
    WebElement ratingBtn;

    @FindBy(css = "input.button-1.write-product-review-button")
    WebElement submitReviewBtn;

    @FindBy(css = "div.result")
    public WebElement reviewResult;

    public void addReview(String title, String text) {
        setTextElementText(reviewTitle, title);
        setTextElementText(reviewText, text);
        clickButton(ratingBtn);
        clickButton(submitReviewBtn);
    }
}
