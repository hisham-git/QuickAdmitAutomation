package pageObjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class LoginAccountCreationPage {
	final WebDriver driver;
	
	public LoginAccountCreationPage(WebDriver driver){
		this.driver = driver;
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
	public WebElement btn_Create ;
	
	@FindBy(how = How.CSS, using = "input[value=\"Back\"]")
	public WebElement btn_Back ;	

// This method will take two arguments ( Username nd Password)

	public void AccountCreate_Action(Map<String, String> config){

		txtbx_FirstName.sendKeys(config.get("First Name"));
		txtbx_MiddleName.sendKeys(config.get("Middle Name"));
		txtbx_LastName.sendKeys(config.get("Last Name"));

		txtbx_Birthday.sendKeys(config.get("Birthday"));
		txtbx_Email.sendKeys(config.get("Email"));
		
		txtbx_Login.sendKeys(config.get("Login"));
		txtbx_Password.sendKeys(config.get("Password"));
		txtbx_VerifyPassword.sendKeys(config.get("Verify Password"));
		
		txtbx_SecretQuestion.sendKeys(config.get("Secret Question"));
		txtbx_SecretAnswer.sendKeys(config.get("Secret Answer"));
		btn_Create.click();
	}


}
