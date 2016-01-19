package pageObjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {
	final WebDriver driver;
	
	public ChangePasswordPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "oldPassword")
	public WebElement txtbx_currentPassword;

	@FindBy(how = How.ID, using = "newPassword")
	public WebElement txtbx_newPassword;
	
	@FindBy(how = How.ID, using = "newPasswordConfirm")
	public WebElement txtbx_confirmPassword;
	
	@FindBy(how = How.ID, using = "submitButton")
	public WebElement btn_go;


// This method will take two arguments ( Username nd Password)

	public void ChangePass_Action(Map<String, String> inputData){

		txtbx_currentPassword.sendKeys(inputData.get("Current password"));
		txtbx_currentPassword.sendKeys(inputData.get("New password"));
		txtbx_currentPassword.sendKeys(inputData.get("Confirm password"));
		btn_go.click();
	}


}
