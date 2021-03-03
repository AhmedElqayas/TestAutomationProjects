package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="small-searchterms")
    WebElement searchTxtBox;

    @FindBy(css="input.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(id="ui-id-1")
    List<WebElement> productAutoCompleteList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;


    public void productSearch ( String productName)
    {
        setTextElementText(searchTxtBox, productName);
        clickButton(searchBtn);
    }

    public void openProductDetailsPage(){
        clickButton(productTitle);
    }

    public void productSearchUsingAutoSuggest (String productName){
        setTextElementText(searchTxtBox,productName );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productAutoCompleteList.get(0).click();
    }

}
