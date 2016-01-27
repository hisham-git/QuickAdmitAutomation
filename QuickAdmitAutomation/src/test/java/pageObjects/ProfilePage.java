package pageObjects;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(how = How.CSS, using = "input[id='checkboxEthnicityType_1']")
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
	
	
	public void selectAction(WebElement locator, String option){
		Select select = new Select(locator);
		select.selectByVisibleText(option);
	}
	
	public void sendKeysAction(WebElement locator, String value){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
		locator.sendKeys(value);
	}
	
	public void clickAction(WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	
	public void profileUpdate_Action(Map<String, String> config){
		
		sendKeysAction(txtbx_Prefix, config.get("Prefix"));
		sendKeysAction(txtbx_FirstName, config.get("First Name"));
		sendKeysAction(txtbx_MiddleName, config.get("Middle Name"));
		sendKeysAction(txtbx_LastName, config.get("Last Name"));
		sendKeysAction(txtbx_Suffix, config.get("Suffix"));
		sendKeysAction(txtbx_Birthday, config.get("Birthday"));

		selectAction(select_Gender, config.get("Gender"));
		
		sendKeysAction(txtbx_GovID, config.get("Gov ID"));
		
		clickAction(chkbx_EthnicityType);
		clickAction(chkbx_Ethnicity);
	
		sendKeysAction(txtbx_AddressLine1, config.get("Address Line 1"));
		sendKeysAction(txtbx_AddressLine2, config.get("Address Line 2"));
		sendKeysAction(txtbx_AddressLine3, config.get("Address Line 3"));
		
		sendKeysAction(txtbx_City, config.get("City"));

		selectAction(select_Country, config.get("Country"));
		selectAction(select_State, config.get("State"));
		
		sendKeysAction(txtbx_TelephoneNumber, config.get("Telephone Number"));
		sendKeysAction(txtbx_EmailAddress, config.get("Email Address"));
		sendKeysAction(txtbx_SecretQuestion, config.get("Secret Question"));
		sendKeysAction(txtbx_SecretAnswer, config.get("Secret Answer"));
		
		clickAction(btn_save);
		
		/*txtbx_Prefix.sendKeys(config.get("Prefix"));
		txtbx_FirstName.sendKeys(config.get("First Name"));
		txtbx_MiddleName.sendKeys(config.get("Middle Name"));
		txtbx_LastName.sendKeys(config.get("Last Name"));
		txtbx_Suffix.sendKeys(config.get("Suffix"));
		
		txtbx_Birthday.sendKeys(config.get("Birthday"));
		selectAction(select_Gender, config.get("Gender"));
		txtbx_GovID.sendKeys(config.get("Gov ID"));
		
		chkbx_EthnicityType.click();
		chkbx_Ethnicity.click();
		
		txtbx_AddressLine1.sendKeys(config.get("Address Line 1"));
		txtbx_AddressLine2.sendKeys(config.get("Address Line 2"));
		txtbx_AddressLine3.sendKeys(config.get("Address Line 3"));
		txtbx_City.sendKeys(config.get("City"));
		selectAction(select_Country, config.get("Country"));
		selectAction(select_State, config.get("State"));
		txtbx_PostalCode.sendKeys(config.get("Postal Code"));
		
		txtbx_TelephoneNumber.sendKeys(config.get("Telephone Number"));
		txtbx_EmailAddress.sendKeys(config.get("Email Address"));

		
		txtbx_SecretQuestion.sendKeys(config.get("Secret Question"));
		txtbx_SecretAnswer.sendKeys(config.get("Secret Answer"));
		
		btn_save.click();*/
	}


}
