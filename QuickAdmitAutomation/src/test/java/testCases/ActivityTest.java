package testCases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
import utilities.Log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

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

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void setUP(String browserType, String appURL) {
		DOMConfigurator.configure("log4j.xml");
//		BasicConfigurator.configure();
	
		driver = BrowserFactory.getBrowser(browserType);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = appURL;
		basePage = PageFactory.initElements(driver, BasePage.class);
	}
	
	@Test(enabled=true, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void accountCreatonTest(Map<String, String> data) throws InterruptedException {
		Thread.sleep(5000);
		driver.get(baseURL + "/modules/login/index.html?action=createAccount");
		Log.startTestCase(data.get("Test Case ID"));
		Log.info("Navigating to Create Account URL");
		loginACPage = PageFactory.initElements(driver, LoginAccountCreationPage.class);
		loginACPage.AccountCreate_Action(data);
		Log.endTestCase(data.get("Test Case ID"));
	//	basePage.Logout_Action();
	}

	@Test(enabled=false, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
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
//		programCatalogsPage = PageFactory.initElements(driver, ProgramCatalogsPage.class);
//		programCatalogsPage.getCatalogs();
	//	programCatalogsPage.Logout_Action();
		Thread.sleep(5000);
	}
	
	@Test(enabled=false, dependsOnMethods={"loginTest"})
	public void navigationTest(){
		basePage.navigateToCurrentSections();
		basePage.navigateToPayBalances();
	}
	
	@Test(enabled=false, dependsOnMethods={"loginTest"}, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void profileUpdateTest(Map<String, String> data) throws InterruptedException {
//		driver.get(baseURL + "/modules/customer/index.html?action=profile");
		basePage.navigateToUpdateProfile();
	//	Thread.sleep(5000);
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		profilePage.profileUpdate_Action(data);
		System.out.println(" Account updated Successfully");
//		basePage.Logout_Action();
	}
	
	@Test(enabled=false, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void changePasswordTest(Map<String, String> data) throws InterruptedException {
	//	driver.get(baseURL + "/modules/customer/index.html?action=password");
		basePage.navigateToChangePassword();
		Thread.sleep(5000);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
		changePasswordPage.ChangePass_Action(data);
	}

	@AfterClass
	public void shutDown() {
//		basePage.Logout_Action();
		BrowserFactory.closeAllDriver();
//		driver.close();

	}

}