package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class LoginAccountCreationPage extends BasePage {

	public LoginAccountCreationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "FirstNameID")
	public WebElement txtbx_FirstName;

	@FindBy(how = How.ID, using = "MiddleNameID")
	public WebElement txtbx_MiddleName;

	@FindBy(how = How.ID, using = "LastNameID")
	public WebElement txtbx_LastName;

	@FindBy(how = How.ID, using = "BirthdayID")
	public WebElement txtbx_Birthday;

	@FindBy(how = How.ID, using = "EmailID")
	public WebElement txtbx_Email;

	@FindBy(how = How.ID, using = "UserLoginID")
	public WebElement txtbx_Login;

	@FindBy(how = How.ID, using = "PasswordID")
	public WebElement txtbx_Password;

	@FindBy(how = How.ID, using = "VerifyPasswordID")
	public WebElement txtbx_VerifyPassword;

	@FindBy(how = How.ID, using = "SecretQuestionID")
	public WebElement txtbx_SecretQuestion;

	@FindBy(how = How.ID, using = "SecretAnswerID")
	public WebElement txtbx_SecretAnswer;

	@FindBy(how = How.CSS, using = "input[value=\"Create\"]")
	public WebElement btn_Create;

	@FindBy(how = How.CSS, using = "input[value=\"Back\"]")
	public WebElement btn_Back;

	public void AccountCreate_Action(Map<String, String> data) {

		sendKeysAction(txtbx_FirstName, data.get("First Name"));
		sendKeysAction(txtbx_MiddleName, data.get("Middle Name"));
		sendKeysAction(txtbx_LastName, data.get("Last Name"));

		sendKeysAction(txtbx_Birthday, data.get("Birthday"));
		sendKeysAction(txtbx_Email, data.get("Email"));

		sendKeysAction(txtbx_Login, data.get("Login"));
		sendKeysAction(txtbx_Password, data.get("Password"));
		sendKeysAction(txtbx_VerifyPassword, data.get("Verify Password"));

		sendKeysAction(txtbx_SecretQuestion, data.get("Secret Question"));
		sendKeysAction(txtbx_SecretAnswer, data.get("Secret Answer"));

		clickAction(btn_Create);
		clickAction(btn_Back);
	}

}
