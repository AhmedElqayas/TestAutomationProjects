package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {


    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    public void openRegistrationPage()
    {
        clickButton(registerLink);
    }

    @FindBy(linkText ="Log in")
    WebElement loginLink;

    public void openLoginPage(){
        clickButton(loginLink);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    public void openContactUsPage(){
        scrollToButton();
        clickButton(contactUsLink);
    }

    @FindBy(id="customerCurrency")
    WebElement currencyList;

    public void changeCurrency(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }

    @FindBy(linkText = "Computers ")
    WebElement computersLink;

    @FindBy(linkText = "Notebooks ")
    WebElement notebooksLink;

    public void hoverAndSelectNotebooksMenu(){
        actions.moveToElement(computersLink).moveToElement(notebooksLink).click().build().perform();
    }
}
