package pageObjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.Select;

public class ProfilePage {
	final WebDriver driver;
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[id^='prefixNameID_']")
	public WebElement txtbx_Prefix;
	
	@FindBy(how = How.CSS, using = "input[id^='firstNameID_']")
	public WebElement txtbx_FirstName;
	
	@FindBy(how = How.CSS, using = "input[id^='middleNameID_']")
	public WebElement txtbx_MiddleName;

	@FindBy(how = How.CSS, using = "input[id^='lastNameID_']")
	public WebElement txtbx_LastName;
	
	@FindBy(how = How.CSS, using = "input[id^='suffixNameID_']")
	public WebElement txtbx_Suffix;
	
	
	// Personal Information block
	
	@FindBy(how = How.CSS, using = "input[id^='birthdateTextID_']")
	public WebElement txtbx_Birthday;
	
	@FindBy(how = How.CSS, using = "select[id^='genderID_']")
	public WebElement select_Gender;
	
	@FindBy(how = How.CSS, using = "input[id^='govIDMask_']")
	public WebElement txtbx_GovID;
	
	
	// Ethnicity block
	
	@FindBy(how = How.CSS, using = "input[id^='checkboxEthnicityTypeID_']")
	public WebElement chkbx_EthnicityType;
	
	@FindBy(how = How.CSS, using = "input[id^='checkboxEthnicityType_']")
	public WebElement chkbx_Ethnicity;
	
	
	// Billing Address block
	
	@FindBy(how = How.CSS, using = "input[id^='addressLine1ID_']")
	public WebElement txtbx_AddressLine1;
	
	@FindBy(how = How.CSS, using = "input[id^='addressLine2ID_']")
	public WebElement txtbx_AddressLine2;
	
	@FindBy(how = How.CSS, using = "input[id^='addressLine3ID_']")
	public WebElement txtbx_AddressLine3;
	
	@FindBy(how = How.CSS, using = "input[id^='cityID_']")
	public WebElement txtbx_City;
	
	@FindBy(how = How.CSS, using = "select[id^='stateID_']")
	public WebElement select_State;
	
	@FindBy(how = How.CSS, using = "input[id^='postalCodeID_']")
	public WebElement txtbx_PostalCode;
	
	@FindBy(how = How.CSS, using = "select[id^='countryCodeID_']")
	public WebElement select_Country;
	
	
	// Contact block
	
	@FindBy(how = How.CSS, using = "input[id^='workTelephoneNumberID_']")
	public WebElement txtbx_TelephoneNumber ;
	
	@FindBy(how = How.CSS, using = "input[id^='emailAddressID_']")
	public WebElement txtbx_EmailAddress;
	

	// Login block
	
	@FindBy(how = How.CSS, using = "input[id^='secretQuestionID_']")
	public WebElement txtbx_SecretQuestion;
	
	@FindBy(how = How.CSS, using = "input[id^='secretAnswerID_']")
	public WebElement txtbx_SecretAnswer;
	
	
	// save button

	@FindBy(how = How.CSS, using = "input[value='Save']")
	public WebElement btn_save ;
	

// This method will take two arguments ( Username nd Password)

	public void AccountCreate_Action(Map<String, String> config){
		
		txtbx_Prefix.sendKeys(config.get("Prefix"));
		txtbx_FirstName.sendKeys(config.get("First Name"));
		txtbx_MiddleName.sendKeys(config.get("Middle Name"));
		txtbx_LastName.sendKeys(config.get("Last Name"));
		txtbx_Suffix.sendKeys(config.get("Suffix"));

		txtbx_Birthday.sendKeys(config.get("Birthday"));
		Select genderValue = new Select(select_Gender);
		genderValue.selectByVisibleText("Gender");
		txtbx_GovID.sendKeys(config.get("Gov ID"));
		
		txtbx_EmailAddress.sendKeys(config.get("Email Address"));

		
		txtbx_SecretQuestion.sendKeys(config.get("Secret Question"));
		txtbx_SecretAnswer.sendKeys(config.get("Secret Answer"));
		btn_save.click();
	}


}
