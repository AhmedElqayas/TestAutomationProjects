package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase {

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="table.compare-products-table")
    WebElement compareTable;

    @FindBy(tagName = "tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "td")
    public List<WebElement> allCol;

    @FindBy(css = "a.clear-list")
    WebElement clearListBtn;

    @FindBy(css = "div.no-data")
    public WebElement noDataMessage;

   // in the test, check if the two products are displayed
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement firstProductName;

    @FindBy(linkText = "Samsung Series 9 NP900X4C Premium Ultrabook")
    public WebElement secondProductName;

    public void clearCompareList(){
        clickButton(clearListBtn);
    }

    public void compareProducts(){

        //get all rows
        System.out.println(allRows.size());

        //get data rom each row
        for(WebElement row : allRows)
        {
            System.out.println(row.getText() + "\t");
            for(WebElement col : allCol)
            {
                System.out.println(col.getText() + "\t");
            }
        }
    }


}
