package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase {

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id="NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id="ConfirmNewPassword")
    WebElement confirmNewPasswordTxtBox;

    @FindBy(css="input.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css="div.result")
    public WebElement changePasswordResult;

    public void changePassword(String oldPassword, String newPassword){
        setTextElementText(oldPasswordTxtBox, oldPassword);
        setTextElementText(newPasswordTxtBox, newPassword);
        setTextElementText(confirmNewPasswordTxtBox, newPassword);
        clickButton(changePasswordBtn);
    }

    @FindBy(linkText = "Log out")
    WebElement logoutFromChangePasswordLink;

    public void logoutFromChangePasswordPage(){
        clickButton(logoutFromChangePasswordLink);
    }
}
