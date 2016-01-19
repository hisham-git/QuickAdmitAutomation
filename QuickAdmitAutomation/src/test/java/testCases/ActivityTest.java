package testCases;

import java.util.concurrent.TimeUnit;

import pageObjects.ChangePasswordPage;
import pageObjects.LoginPage;
import utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ActivityTest {

	static WebDriver driver;
	LoginPage loginPage;
	ChangePasswordPage changePasswordPage;
//	LogoutPage logoutPage;

	@BeforeMethod

	public void beforeMethod() {

		driver = BrowserFactory.getBrowser("IE");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://gateway1.dev.campusops.net/modules/customer/index.html");

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
//		logoutPage = PageFactory.initElements(driver, LogoutPage.class);

	}

	@Test
	public void loginTest() {
		loginPage.LogIn_Action("jcarter.dsi", "12345678");
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	}
	
	@Test
	public void changePasswordTest() {
		ChangePasswordPage.ChangePass_Action("jcarter.dsi", "12345678");
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}

}