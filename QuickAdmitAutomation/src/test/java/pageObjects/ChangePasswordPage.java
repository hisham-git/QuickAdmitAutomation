package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ChangePasswordPage extends BasePage {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "oldPassword")
	public WebElement txtbx_currentPassword;
	
	//This field is required.||Please enter at least 8 characters.
	@FindBy(how = How.XPATH, using = ".//*[@id='content1']/table/tbody/tr[2]/td[2]/span")
	public WebElement errtxt_currentPassword;


	@FindBy(how = How.ID, using = "newPassword")
	public WebElement txtbx_newPassword;
	
	//This field is required.||Please enter at least 8 characters.
	@FindBy(how = How.XPATH, using = ".//*[@id='content1']/table/tbody/tr[4]/td[2]/span")
	public WebElement errtxt_newPassword;
	

	@FindBy(how = How.ID, using = "newPasswordConfirm")
	public WebElement txtbx_confirmPassword;
	
	//This field is required.||Confirm password must match the new password.
	@FindBy(how = How.XPATH, using = ".//*[@id='content1']/table/tbody/tr[6]/td[2]/span")
	public WebElement errtxt_confirmPassword;
	
	
	//changePassword failed --- Invalid password||Please enter at least 8 characters.
	@FindBy(how = How.CSS, using = "p[id='errorMsg']")
	public WebElement errtxt_changePassword;
		
	//You have successfully changed the password.
	@FindBy(how = How.CSS, using = "div[id='successMsg'] > p")
	public WebElement successtxt_changePassword;
	

	@FindBy(how = How.ID, using = "submitButton")
	public WebElement btn_goElement;

	public void ChangePass_Action(Map<String, String> data) {
		sendKeysAction(txtbx_currentPassword, data.get("Current password"));
		sendKeysAction(txtbx_newPassword, data.get("New password"));
		sendKeysAction(txtbx_confirmPassword, data.get("Confirm password"));
		clickAction(btn_goElement);
		wait.until(ExpectedConditions.visibilityOf(successtxt_changePassword));
		if( null != (successtxt_changePassword.getText()) ){
			try {
				Assert.assertEquals(successtxt_changePassword.getText(), "You have successfully changed the password.");
				System.out.println("Password update Successfull");
			} catch (Exception e) {
				System.out.println("Password update message not matching");
			}
			
		} else if( null != (errtxt_currentPassword.getText()) ) {
			//This field is required.||Please enter at least 8 characters.
			
		} else if( null != (errtxt_newPassword.getText()) ) {
			
		} else if( null != (errtxt_confirmPassword.getText()) ) {
			
		} else if( null != (errtxt_changePassword.getText()) ) {
			
		} 
		
		
		
		else {
			System.out.println("Password update Failed");
		}
	}
}
