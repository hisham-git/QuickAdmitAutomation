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
	
	
	//changePassword failed --- Invalid password
	@FindBy(how = How.CSS, using = "p[id='errorMsg']")
	public WebElement errtxt_changePassword;
		
	//You have successfully changed the password.
	@FindBy(how = How.CSS, using = "div[id='successMsg'] > p")
	public WebElement successtxt_changePassword;
	

	@FindBy(how = How.ID, using = "submitButton")
	public WebElement btn_goElement;

	public void ChangePass_Action(Map<String, String> data) throws InterruptedException {
		sendKeysAction(txtbx_currentPassword, data.get("Current password"));
		sendKeysAction(txtbx_newPassword, data.get("New password"));
		sendKeysAction(txtbx_confirmPassword, data.get("Confirm password"));
		clickAction(btn_goElement);
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visi(successtxt_changePassword));
		if( "" != (successtxt_changePassword.getText()) ){
			try {
				Assert.assertEquals(successtxt_changePassword.getText(), "You have successfully changed the password.");
				System.out.println("Passed => |" + data.get("Test Case ID") + "| " + data.get("Test Case"));
			} catch (Exception e) {
				System.out.println("Password update message not matching");
			}
			
		} else if( "" != (errtxt_currentPassword.getText()) ) {
			//This field is required.||Please enter at least 8 characters.
			if(errtxt_currentPassword.getText().equals("This field is required.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else if(errtxt_currentPassword.getText().equals("Please enter at least 8 characters.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else {
				System.out.println("Failed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));
				System.out.println("Current Password field doesn't have proper Validation Message");
			}
			
		} else if( "" != (errtxt_newPassword.getText()) ) {
			//This field is required.||Please enter at least 8 characters.
			if(errtxt_newPassword.getText().equals("This field is required.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else if(errtxt_newPassword.getText().equals("Please enter at least 8 characters.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else {
				System.out.println("Failed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));
				System.out.println("New Password field doesn't have proper Validation Message");
			}
			
		} else if( "" != (errtxt_confirmPassword.getText()) ) {
			//This field is required.||Please enter at least 8 characters.||Confirm password must match the new password.
			if(errtxt_confirmPassword.getText().equals("This field is required.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else if(errtxt_confirmPassword.getText().equals("Please enter at least 8 characters.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else if(errtxt_confirmPassword.getText().equals("Confirm password must match the new password.")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else {
				System.out.println("Failed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));
				System.out.println("Confirm Password field doesn't have proper Validation Message");
			}
			
		} else if( "" != (errtxt_changePassword.getText()) ) {
			//changePassword failed --- Invalid password
			if(errtxt_changePassword.getText().equals("changePassword failed --- Invalid password")){
				System.out.println("Passed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));	
			} else {
				System.out.println("Failed => | " + data.get("Test Case ID") + " | " + data.get("Test Case"));
				System.out.println("Invalid Password Validation Message is missing");
			}
		} else {
			System.out.println("Password update Failed");
		}
	}
}
