package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.ChangePasswordPage;
import pageObjects.LoginAccountCreationPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import utilities.BrowserFactory;
import utilities.ExcelFileReaderConfig;

public class ActivityTest {

	static WebDriver driver;
	static String baseURL;
	LoginPage loginPage;
	ChangePasswordPage changePasswordPage;
	BasePage basePage;
	LoginAccountCreationPage loginACPage;
	ProfilePage profilePage;
//	LogoutPage logoutPage;

	@BeforeClass

	public void setUP() {

		driver = BrowserFactory.getBrowser("Chrome");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		baseURL = "http://gateway1.dev.campusops.net";
		baseURL = "http://hirebox.jenzabar.com";
//		baseURL = "http://hiredemo.jenzabar.com";
		basePage = PageFactory.initElements(driver, BasePage.class);
	}


	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void loginTest(Map<String, String> config) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html");
		Thread.sleep(5000);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.LogIn_Action(config);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		
	}
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void accountCreatonTest(Map<String, String> config) throws InterruptedException {
		driver.get(baseURL + "/modules/login/index.html?action=createAccount&URL=https://gateway1.dev.campusops.net/modules/customer/index.html");
		loginACPage = PageFactory.initElements(driver, LoginAccountCreationPage.class);
		loginACPage.AccountCreate_Action(config);
		System.out.println(" Account created Successfully");
	//	basePage.Logout_Action();
	}
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void profileUpdateTest(Map<String, String> config) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html?action=profile");
		Thread.sleep(5000);
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		profilePage.profileUpdate_Action(config);
		System.out.println(" Account updated Successfully");
		basePage.Logout_Action();
	}
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
	public void changePasswordTest(Map<String, String> config) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html?action=password");
		Thread.sleep(5000);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
		changePasswordPage.ChangePass_Action(config);
		System.out.println("Password updated Successfully");
		basePage.Logout_Action();
	}

	@AfterClass
	public void afterMethod() {

		driver.close();

	}

}