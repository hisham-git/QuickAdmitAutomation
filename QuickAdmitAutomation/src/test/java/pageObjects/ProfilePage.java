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

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
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
	public WebElement txtbx_TelephoneNumber;

	@FindBy(how = How.CSS, using = "input[id^='emailAddressID_']")
	public WebElement txtbx_EmailAddress;

	// Login block

	@FindBy(how = How.CSS, using = "input[id^='secretQuestionID_']")
	public WebElement txtbx_SecretQuestion;

	@FindBy(how = How.CSS, using = "input[id^='secretAnswerID_']")
	public WebElement txtbx_SecretAnswer;

	// save button

	@FindBy(how = How.CSS, using = "input[value='Save']")
	public WebElement btn_save;
	

	public void profileUpdate_Action(Map<String, String> data) {
		
//		wait.until(ExpectedConditions.visibilityOf(select_State));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("select")));
		
		sendKeysAction(txtbx_Prefix, data.get("Prefix"));
		sendKeysAction(txtbx_FirstName, data.get("First Name"));
		sendKeysAction(txtbx_MiddleName, data.get("Middle Name"));
		sendKeysAction(txtbx_LastName, data.get("Last Name"));
		sendKeysAction(txtbx_Suffix, data.get("Suffix"));
		sendKeysAction(txtbx_Birthday, data.get("Birthday"));

		selectAction(select_Gender, data.get("Gender"));

		sendKeysAction(txtbx_GovID, data.get("Gov ID"));

		clickAction(chkbx_EthnicityType);
		clickAction(chkbx_Ethnicity);

		sendKeysAction(txtbx_AddressLine1, data.get("Address Line 1"));
		sendKeysAction(txtbx_AddressLine2, data.get("Address Line 2"));
		sendKeysAction(txtbx_AddressLine3, data.get("Address Line 3"));

		sendKeysAction(txtbx_City, data.get("City"));

		selectAction(select_Country, data.get("Country"));
		selectAction(select_State, data.get("State"));

		sendKeysAction(txtbx_TelephoneNumber, data.get("Telephone Number"));
		sendKeysAction(txtbx_EmailAddress, data.get("Email Address"));
		sendKeysAction(txtbx_SecretQuestion, data.get("Secret Question"));
		sendKeysAction(txtbx_SecretAnswer, data.get("Secret Answer"));

		clickAction(btn_save);

	}

}
