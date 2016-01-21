package pageObjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class LoginPage {
	final WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "focustarget")
	public WebElement txtbx_Login;

	@FindBy(how = How.ID, using = "j_passwordID")
	public WebElement txtbx_Password;

	@FindBy(how = How.CSS, using = "input[type=\"submit\"]")
	public WebElement btn_Login ;

	

// This method will take two arguments ( Username nd Password)

	public void LogIn_Action(Map<String, String> config){

		txtbx_Login.sendKeys(config.get("UserName"));

		txtbx_Password.sendKeys(config.get("Password"));

		btn_Login.click();

	}


}
