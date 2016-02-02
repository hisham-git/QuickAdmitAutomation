package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "focustarget")
	public WebElement txtbx_Login;

	@FindBy(how = How.ID, using = "j_passwordID")
	public WebElement txtbx_Password;

	@FindBy(how = How.CSS, using = "input[type=\"submit\"]")
	public WebElement btn_Login;

	public void LogIn_Action(Map<String, String> data) {
		sendKeysAction(txtbx_Login, data.get("UserName"));
		sendKeysAction(txtbx_Password, data.get("Password"));
		clickAction(btn_Login);
	}
}
