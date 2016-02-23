package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginAccountCreationPage extends BasePage {

	public LoginAccountCreationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(how = How.ID, using = "ERPID")
	public WebElement txtbx_ERPID;

	@FindBy(how = How.ID, using = "FirstNameID")
	public WebElement txtbx_FirstName;
	
	// This field is required.
	@FindBy(how = How.CSS, using = "input[id='FirstNameID'] + span")
	public WebElement errtxt_FirstName;
	

	@FindBy(how = How.ID, using = "MiddleNameID")
	public WebElement txtbx_MiddleName;
	
	@FindBy(how = How.CSS, using = "input[id='MiddleNameID'] + span")
	public WebElement errtxt_MiddleName;
	
	
	@FindBy(how = How.ID, using = "LastNameID")
	public WebElement txtbx_LastName;
	
	//This field is required.
	@FindBy(how = How.CSS, using = "input[id='LastNameID'] + span")
	public WebElement errtxt_LastName;

	@FindBy(how = How.ID, using = "BirthdayID")
	public WebElement txtbx_Birthday;
	
	//Over 100 years from this year is invalid.||Invalid date||Birthday should be in the past.
	@FindBy(how = How.CSS, using = "input[id='BirthdayID'] + span + span")
	public WebElement errtxt_Birthday;	

	
	@FindBy(how = How.ID, using = "EmailID")
	public WebElement txtbx_Email;
	
	//Please enter a valid email address.
	@FindBy(how = How.CSS, using = "input[id='EmailID'] + span")
	public WebElement errtxt_Email;	

	
	@FindBy(how = How.ID, using = "UserLoginID")
	public WebElement txtbx_Login;
	
	//This field is required.||Please enter at least 6 characters.
	@FindBy(how = How.CSS, using = "input[id='UserLoginID'] + span")
	public WebElement errtxt_Login;	
	

	@FindBy(how = How.ID, using = "PasswordID")
	public WebElement txtbx_Password;
	
	//This field is required.||Please enter at least 8 characters.
	@FindBy(how = How.CSS, using = "input[id='PasswordID'] + span")
	public WebElement errtxt_Password;	
		

	@FindBy(how = How.ID, using = "VerifyPasswordID")
	public WebElement txtbx_VerifyPassword;

	//Password entries do not match
	@FindBy(how = How.CSS, using = "input[id='VerifyPasswordID'] + span")
	public WebElement errtxt_VerifyPassword;
	
	
	@FindBy(how = How.ID, using = "SecretQuestionID")
	public WebElement txtbx_SecretQuestion;
	
	//This field is required.
	@FindBy(how = How.CSS, using = "input[id='SecretQuestionID'] + span")
	public WebElement errtxt_SecretQuestion;
	

	@FindBy(how = How.ID, using = "SecretAnswerID")
	public WebElement txtbx_SecretAnswer;
	
	//This field is required.
	@FindBy(how = How.CSS, using = "input[id='SecretAnswerID'] + span")
	public WebElement errtxt_SecretAnswer;	
	

	@FindBy(how = How.CSS, using = "input[value='Create']")
	public WebElement btn_Create;

	@FindBy(how = How.CSS, using = "input[value='Back']")
	public WebElement btn_Back;
	
	@FindBy(how = How.CSS, using = "input[value='Go to login']")
	public WebElement btn_Gotologin;
	
	//Thank you for creating an account. You may now log in!
	@FindBy(how = How.CSS, using = "div[id='successTarget'] > span")
	public WebElement successtxt_Create;
	
	//A Person with this information already exists.||The user login already exists and a new user login needs to be entered.
	@FindBy(how = How.CSS, using = "div[id='displayMessageBlock'] > span")
	public WebElement errtxt_DuplicateAccount;
	

	public String AccountCreate_Action(Map<String, String> data) {
		
		sendKeysAction(txtbx_ERPID, data.get("ERP ID"));

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
		wait.until(ExpectedConditions.visibilityOf(successtxt_Create));
		if( null != (successtxt_Create.getText()) ){
			return successtxt_Create.getText();
		} else {
			return null;
		}		
//		clickAction(btn_Back);
	}

}
