package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	final WebDriver driver;
	final WebDriverWait wait;
	// final Wait<FluentWait> wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		// this.wait = new FluentWait(driver).withTimeout(30,
		// TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
	}

	@FindBy(how = How.CSS, using = "a[id='logout']")
	public WebElement logout_link;
	
	@FindBy(how = How.CSS, using = "li[id='usertarget']")
	public WebElement login_user;

	/*
	 * @FindBy(how = How.ID, using = "oldPassword") public WebElement
	 * txtbx_currentPassword;
	 * 
	 * @FindBy(how = How.ID, using = "newPassword") public WebElement
	 * txtbx_newPassword;
	 * 
	 * @FindBy(how = How.ID, using = "newPasswordConfirm") public WebElement
	 * txtbx_confirmPassword;
	 * 
	 * @FindBy(how = How.ID, using = "submitButton") public WebElement btn_go;
	 */

	/*
	 * public WebElement fluentWait(final By locator){ Wait<WebDriver> wait =
	 * new FluentWait<WebDriver>(driver) .withTimeout(30, TimeUnit.SECONDS)
	 * .pollingEvery(5, TimeUnit.SECONDS)
	 * .ignoring(NoSuchElementException.class);
	 * 
	 * WebElement foo = wait.until( new Function<WebDriver, WebElement>() {
	 * public WebElement apply(WebDriver driver) { return
	 * driver.findElement(locator); } } ); return foo; }
	 */

	public void Logout_Action() {
		clickAction(logout_link);
	}

	public void selectAction(WebElement locator, String option) {
		Select select = new Select(locator);
		select.selectByVisibleText(option);
	}

	public void sendKeysAction(WebElement locator, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (locator.isDisplayed()) {
		//	locator.clear();
			locator.sendKeys(value);
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			locator.clear();
			locator.sendKeys(value);
		} 
	}

	public void clickAction(WebElement locator) {
		if (locator.isDisplayed()) {
			locator.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
		}
	}

}
