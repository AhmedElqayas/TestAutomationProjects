package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="FriendEmail")
    WebElement friendEmailTxtBox;

    @FindBy(id = "PersonalMessage")
    WebElement emailMessage;

    @FindBy(css="input.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement sendEmailResult;

    public void sendEmail(String friendEmail, String message){
        setTextElementText(friendEmailTxtBox, friendEmail);
        setTextElementText(emailMessage, message);
        clickButton(sendEmailBtn);
    }
}
