package testCases;

import java.util.concurrent.TimeUnit;

import pageObjects.LoginPage;
import utilities.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	static WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod

	public void beforeMethod() {

		driver = BrowserFactory.getBrowser("IE");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://gateway1.dev.campusops.net/modules/customer/index.html");

		loginPage = PageFactory.initElements(driver, LoginPage.class);

	}

	@Test
	public void test() {

		loginPage.LogIn_Action("jcarter.dsi", "12345678");

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}

}