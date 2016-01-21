package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.ChangePasswordPage;
import pageObjects.LoginAccountCreationPage;
import pageObjects.LoginPage;
import utilities.BrowserFactory;
import utilities.ExcelFileReaderConfig;

public class ActivityTest {

	static WebDriver driver;
	LoginPage loginPage;
	ChangePasswordPage changePasswordPage;
	BasePage basePage;
	LoginAccountCreationPage loginACPage;
//	LogoutPage logoutPage;

	@BeforeClass

	public void beforeMethod() {

		driver = BrowserFactory.getBrowser("Firefox");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.get("https://gateway1.dev.campusops.net/modules/customer/index.html");
		
	//	loginPage = PageFactory.initElements(driver, LoginPage.class);
	//	changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
	//	basePage = PageFactory.initElements(driver, BasePage.class);

	}


	/*@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void loginTest(Map<String, String> config) {
		loginPage.LogIn_Action(config);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		basePage.Logout_Action();
	}*/
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void accountCreatonTest(Map<String, String> config) {
		driver.get("https://gateway1.dev.campusops.net/modules/login/index.html?action=createAccount&URL=https://gateway1.dev.campusops.net/modules/customer/index.html");
		loginACPage = PageFactory.initElements(driver, LoginAccountCreationPage.class);
		loginACPage.AccountCreate_Action(config);
		System.out.println(" Account created Successfully");
	//	basePage.Logout_Action();
	}
	
	/*@Test
	public void changePasswordTest() {
		ChangePasswordPage.ChangePass_Action("jcarter.dsi", "12345678");
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	}*/

	@AfterClass
	public void afterMethod() {

		driver.close();

	}

}