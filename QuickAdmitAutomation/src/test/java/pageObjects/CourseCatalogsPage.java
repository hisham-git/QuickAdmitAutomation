package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

public class CourseCatalogsPage extends BasePage {

	public CourseCatalogsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "img[title='Catalog list']")
	public WebElement catalog_list;
	
	@FindBy(how = How.CSS, using = "img[title='Catalog grid']")
	public WebElement catalog_grid;
	
	@FindBy(how = How.CSS, using = "a[onclick^='forwardToCourseBrowse']")
	public WebElement catalog_links;

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
