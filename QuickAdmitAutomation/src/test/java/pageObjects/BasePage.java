package pageObjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {
	final WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "a[id=\"logout\"]")
	public WebElement logout_link;


/*	@FindBy(how = How.ID, using = "oldPassword")
	public WebElement txtbx_currentPassword;

	@FindBy(how = How.ID, using = "newPassword")
	public WebElement txtbx_newPassword;
	
	@FindBy(how = How.ID, using = "newPasswordConfirm")
	public WebElement txtbx_confirmPassword;
	
	@FindBy(how = How.ID, using = "submitButton")
	public WebElement btn_go;*/

	public void Logout_Action(){
		logout_link.click();
	}


}
