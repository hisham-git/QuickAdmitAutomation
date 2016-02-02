package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage extends BasePage {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "oldPassword")
	public WebElement txtbx_currentPassword;

	@FindBy(how = How.CSS, using = "span[class='error'][generated='true']")
	public WebElement errmsg_currentPassword;

	@FindBy(how = How.ID, using = "newPassword")
	public WebElement txtbx_newPassword;

	@FindBy(how = How.ID, using = "newPasswordConfirm")
	public WebElement txtbx_confirmPassword;

	@FindBy(how = How.ID, using = "submitButton")
	public WebElement btn_goElement;

	public void ChangePass_Action(Map<String, String> data) {
		sendKeysAction(txtbx_currentPassword, data.get("Current password"));
		sendKeysAction(txtbx_newPassword, data.get("New password"));
		sendKeysAction(txtbx_confirmPassword, data.get("Confirm password"));
		clickAction(btn_goElement);
	}
}
