package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.ChangePasswordPage;
import pageObjects.CourseCatalogsPage;
import pageObjects.LoginAccountCreationPage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import pageObjects.ProgramCatalogsPage;
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
	CourseCatalogsPage courseCatalogsPage;
	ProgramCatalogsPage programCatalogsPage;
//	LogoutPage logoutPage;

	@BeforeClass

	public void setUP() {

		driver = BrowserFactory.getBrowser("Chrome");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		baseURL = "http://gateway1.dev.campusops.net";
//		baseURL = "http://hirebox.jenzabar.com";
		baseURL = "http://hiredemo.jenzabar.com";
//		baseURL = "http://ec2-54-208-65-58.compute-1.amazonaws.com";
		basePage = PageFactory.initElements(driver, BasePage.class);
	}


	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void loginTest(Map<String, String> data) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html");
		Thread.sleep(5000);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.LogIn_Action(data);
		System.out.println(loginPage.getLoginUser() + " Logged in Successfully");
		Thread.sleep(5000);
		courseCatalogsPage = PageFactory.initElements(driver, CourseCatalogsPage.class);
		courseCatalogsPage.getCatalogs();
		basePage.navigateToProgramCatalogs();
		Thread.sleep(5000);
		programCatalogsPage = PageFactory.initElements(driver, ProgramCatalogsPage.class);
		programCatalogsPage.getCatalogs();
		programCatalogsPage.Logout_Action();
		Thread.sleep(5000);
	}
	
	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void accountCreatonTest(Map<String, String> data) throws InterruptedException {
		driver.get(baseURL + "/modules/login/index.html?action=createAccount&URL=https://gateway1.dev.campusops.net/modules/customer/index.html");
		Thread.sleep(5000);
		loginACPage = PageFactory.initElements(driver, LoginAccountCreationPage.class);
		try {
			Assert.assertEquals(loginACPage.AccountCreate_Action(data), "Thank you for creating an account. You may now log in!");
			System.out.println(" Account created Successfully");
		} catch (Exception e) {
			System.out.println(" Account creation failed");
		}
		
	//	basePage.Logout_Action();
	}
	
	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void profileUpdateTest(Map<String, String> data) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html?action=profile");
		Thread.sleep(5000);
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		profilePage.profileUpdate_Action(data);
		System.out.println(" Account updated Successfully");
		basePage.Logout_Action();
	}
	
	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void changePasswordTest(Map<String, String> data) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html?action=password");
		Thread.sleep(5000);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
		changePasswordPage.ChangePass_Action(data);
		System.out.println("Password updated Successfully");
		basePage.Logout_Action();
	}

	@AfterClass
	public void afterMethod() {
		BrowserFactory.closeAllDriver();
//		driver.close();

	}

}