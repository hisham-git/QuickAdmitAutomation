package testCases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.ChangePasswordPage;
import pageObjects.CourseCatalogsPage;
import pageObjects.HomePage;
import pageObjects.LoginAccountCreationPage;
import pageObjects.CustomerLoginPage;
import pageObjects.ProfilePage;
import pageObjects.ProgramCatalogsPage;
import utilities.BrowserFactory;
import utilities.ExcelFileReaderConfig;
import utilities.Log;

public class ActivityTest {

	static WebDriver driver;
	static String baseURL;
	CustomerLoginPage customerLoginPage;
	ChangePasswordPage changePasswordPage;
	BasePage basePage;
	LoginAccountCreationPage loginACPage;
	ProfilePage profilePage;
	CourseCatalogsPage courseCatalogsPage;
	ProgramCatalogsPage programCatalogsPage;
	HomePage homePage;
//	LogoutPage logoutPage;

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void setUP(String browserType, String appURL) throws InterruptedException {
//		DOMConfigurator.configure("log4j.xml");
//		BasicConfigurator.configure();
	
		driver = BrowserFactory.getBrowser(browserType);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = appURL;
		basePage = PageFactory.initElements(driver, BasePage.class);
	}
	
	@Test(enabled=true, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void accountCreatonTest(Map<String, String> data) throws InterruptedException {
		
		driver.get(baseURL + "/modules/index.html");
		homePage = PageFactory.initElements(driver, HomePage.class);
		courseCatalogsPage = homePage.BrowseStudentView_Action();
		
		loginACPage = courseCatalogsPage.navigateToAccountCreation();
		
		Log.startTestCase(data.get("Test Case ID"));
		Log.info("Navigating to Create Account URL");

		loginACPage.AccountCreate_Action(data);
		Log.endTestCase(data.get("Test Case ID"));
	//	basePage.Logout_Action();
	}

	@Test(enabled=false, dataProvider = "getExcelData", dataProviderClass = ExcelFileReaderConfig.class)
	public void loginTest(Map<String, String> data) throws InterruptedException {
		driver.get(baseURL + "/modules/customer/index.html");
		Thread.sleep(5000);
		customerLoginPage = PageFactory.initElements(driver, CustomerLoginPage.class);
		customerLoginPage.LogIn_Action(data);
		System.out.println(customerLoginPage.getLoginUser() + " Logged in Successfully");
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
	}

}