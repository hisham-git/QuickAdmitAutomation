package pageObjects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public WebElement link_logout;
	
	@FindBy(how = How.CSS, using = "a[id='login']")
	public WebElement link_login;
	
	@FindBy(how = How.CSS, using = "li[id='usertarget']")
	public WebElement login_user;
	
	// Find A Course menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(1)>a:nth-child(1)")
	public WebElement link_FindACourse;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=courseCatalogs']")
	public WebElement link_CourseCatalogs;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=courseSearch']")
	public WebElement link_SearchCourses;
	
	
	// Find A Program menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(3)>a:nth-child(1)")
	public WebElement link_FindAProgram;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=programCatalogs']")
	public WebElement link_ProgramCatalogs;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=programSearch']")
	public WebElement link_SearchPrograms;
	
	
	// Academics menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(5)>a:nth-child(1)")
	public WebElement link_Academics;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=programArea']")
	public WebElement link_MyPrograms;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=sections&isCompletedSection=0']")
	public WebElement link_CurrentSections;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=sections&isCompletedSection=1']")
	public WebElement link_CompletedSections;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=schedule']")
	public WebElement link_MySchedule;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=certificates']")
	public WebElement link_MyCertificates;
	
	
	// Enrollment menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(7)>a:nth-child(1)")
	public WebElement link_Enrollment;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=enrollment']")
	public WebElement link_ReservationTicket;
	
	
	// My Account menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(9)>a:nth-child(1)")
	public WebElement link_MyAccount;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=profile']")
	public WebElement link_UpdateProfile;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=password']")
	public WebElement link_ChangePassword;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=orders']")
	public WebElement link_OrderHistory;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=payments']")
	public WebElement link_PaymentHistory;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=paymentSchedule']")
	public WebElement link_PayBalances;
	
	
	// Cart menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(11)>a:nth-child(1)")
	public WebElement link_Cart;
	
	@FindBy(how = How.CSS, using = "div[id='m6'] + a[href='index.html?action=cart&mode=full']")
	public WebElement link_ViewCart;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/checkout.action']")
	public WebElement link_Checkout;	

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


	
	public void navigation(WebElement menu, WebElement submenu){
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		action.moveToElement(submenu);
		action.click();
		action.perform();
	}
	
	/*
	 * Navigation actions start
	 * */
	
	public void navigateToCourseCatalogs(){
		navigation(link_FindACourse, link_CourseCatalogs);
	}
	
	public void navigateToSearchCourses(){
		navigation(link_FindACourse, link_SearchCourses);
	}	
	
	public void navigateToProgramCatalogs(){
		navigation(link_FindAProgram, link_ProgramCatalogs);
	}
	
	public void navigateToSearchPrograms(){
		navigation(link_FindAProgram, link_SearchPrograms);
	}
	
	public void navigateToMyPrograms(){
		navigation(link_Academics, link_MyPrograms);
	}
	
	public void navigateToCurrentSections(){
		navigation(link_Academics, link_CurrentSections);
	}
	
	public void navigateToCompletedSections(){
		navigation(link_Academics, link_CompletedSections);
	}
	
	public void navigateToMySchedule(){
		navigation(link_Academics, link_MySchedule);
	}
	
	public void navigateToMyCertificates(){
		navigation(link_Academics, link_MyCertificates);
	}
	
	public void navigateToReservationTicket(){
		navigation(link_Enrollment, link_ReservationTicket);
	}
	
	public void navigateToUpdateProfile(){
		navigation(link_MyAccount, link_UpdateProfile);
	}
	
	public void navigateToChangePassword(){
		navigation(link_MyAccount, link_ChangePassword);
	}
	
	public void navigateToOrderHistory(){
		navigation(link_MyAccount, link_OrderHistory);
	}
	
	public void navigateToPaymentHistory(){
		navigation(link_MyAccount, link_PaymentHistory);
	}
	
	public void navigateToPayBalances(){
		navigation(link_MyAccount, link_PayBalances);
	}
	
	public void navigateToViewCart(){
		navigation(link_Cart, link_ViewCart);
	}
	
	public void navigateToCheckout(){
		navigation(link_Cart, link_Checkout);
	}
	
	/*
	 * End of Navigation actions
	 * */
	
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
	
	public String getLoginUser() {
		if (login_user.isDisplayed()) {
			return (login_user.getText());
		} else {
			wait.until(ExpectedConditions.visibilityOf(login_user));
			return (login_user.getText());
		}
	}
	
	public void Logout_Action() {
		clickAction(link_logout);
	}

}
