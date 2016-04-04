package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BasePage {
	final WebDriver driver;
	final WebDriverWait wait;
	final FluentWait<WebDriver> fwait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		
		this.fwait = new FluentWait<WebDriver>(driver);
		this.fwait.pollingEvery(250, TimeUnit.MILLISECONDS);
		this.fwait.withTimeout(5, TimeUnit.SECONDS);
	}

	@FindBy(how = How.CSS, using = "a[id='logout']")
	public WebElement link_logout;
	
	@FindBy(how = How.CSS, using = "a[id='login']")
	public WebElement link_login;
	
	@FindBy(how = How.CSS, using = "li[id='usertarget']")
	public WebElement login_user;
	
	// Find A Course menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(1)>a:nth-child(1)")
	@CacheLookup
	public WebElement link_FindACourse;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=courseCatalogs']")
	public WebElement link_CourseCatalogs;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=courseSearch']")
	public WebElement link_SearchCourses;
	
	
	// Find A Program menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(3)>a:nth-child(1)")
	@CacheLookup
	public WebElement link_FindAProgram;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=programCatalogs']")
	public WebElement link_ProgramCatalogs;
	
	@FindBy(how = How.CSS, using = "a[href='index.html?action=programSearch']")
	public WebElement link_SearchPrograms;
	
	
	// Academics menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(5)>a:nth-child(1)")
	@CacheLookup
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
	@CacheLookup
	public WebElement link_Enrollment;
		
	@FindBy(how = How.CSS, using = "a[href='../customer/index.html?action=enrollment']")
	public WebElement link_ReservationTicket;
	
	
	// My Account menu & submenu
	@FindBy(how = How.CSS, using = "ul[id='sddm']>li:nth-child(9)>a:nth-child(1)")
	@CacheLookup
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
	@CacheLookup
	public WebElement link_Cart;
	
	@FindBy(how = How.CSS, using = "div[id='m6'] + a[href='index.html?action=cart&mode=full']")
	public WebElement link_ViewCart;
	
	@FindBy(how = How.CSS, using = "a[href='../customer/checkout.action']")
	public WebElement link_Checkout;
	
	// missing ERP ID info
	@FindBy(how = How.CSS, using = "div[id='erpRequiredMessageBlock'] > span")
	public WebElement info_ERPID;
	
	// Info for Holds
	@FindBy(how = How.CSS, using = "div[id='displayHoldMessageBlock'] > span")
	public WebElement info_Hold;
	
	@FindBy(how = How.CSS, using = "#displayHoldMessageBlock > span > #popUpLink")
	public WebElement click_info_Hold;
	
	// Hold Lists
	@FindBy(how = How.CSS, using = "ul[id='holdNames']")
	public List<WebElement> HoldNames = new ArrayList<WebElement>();
	
	@FindBy(how = How.CSS, using = "span[class='disabled_menu_tooltip']")
	public WebElement disabled_menu_tooltip;
	
	
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
		if( submenu.getAttribute("class").equalsIgnoreCase("disable_a_href") ){
			System.out.println(submenu.getText() + " is Disabled");
			wait.until(ExpectedConditions.visibilityOf(disabled_menu_tooltip));
			System.out.println(disabled_menu_tooltip.getText());
		} else {
			System.out.println(submenu.getText() + " is Enabled");
			action.click();
			action.perform();
		}
	}
	
		
	/*void waitForLoad(WebDriver driver) {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    wait.until(pageLoadCondition);
	    System.out.println(driver.getTitle() + " => Page load complete");
	}*/
	
	void waitForLoad(WebDriver driver) {
		Function<WebDriver, Boolean> pageLoadCondition = new Function<WebDriver, Boolean>() {
	            public Boolean apply(WebDriver driver) {
	            	if ( ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete") ) {
	            		return true;
	            	} 
	            	return false;
	            }
	        };
	    fwait.until(pageLoadCondition);
		String script = ((JavascriptExecutor)driver).executeScript("return document.title").toString();
		System.out.println("Script running : " + script);
	    System.out.println(driver.getTitle() + " => Page load complete");
	}

	
	/*
	 * Navigation actions start
	 * */
	
	public void navigateToCourseCatalogs(){
		navigation(link_FindACourse, link_CourseCatalogs);
		waitForLoad(driver);
	}
	
	public void navigateToSearchCourses(){
		navigation(link_FindACourse, link_SearchCourses);
	}	
	
	public void navigateToProgramCatalogs(){
		navigation(link_FindAProgram, link_ProgramCatalogs);
		waitForLoad(driver);
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
		waitForLoad(driver);
	}
	
	public void navigateToChangePassword(){
		navigation(link_MyAccount, link_ChangePassword);
		waitForLoad(driver);
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
		/*wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (locator.isDisplayed()) {
			locator.clear();
			locator.sendKeys(value);
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			locator.clear();
			locator.sendKeys(value);
		}*/
		
//		wait.until(ExpectedConditions.elementToBeClickable(locator));
		locator.clear();
		locator.click();
		locator.sendKeys(value);
	}

	public void clickAction(WebElement locator) {
		if (locator.isDisplayed()) {
			locator.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
		}
	}
	
	public void getInfo(){
		if ( ("") != (info_ERPID.getText()) ){
			System.out.println("Info Message for Student without ERPID shown below:");
			System.out.println(info_ERPID.getText());
			System.out.println();
		} else {
			System.out.println("Student has ERPID. Info Message not shown");
		}
		
		if ( ("") != (info_Hold.getText()) ){
			System.out.println("Info Message for Student with Holds shown below:");
			System.out.println(info_Hold.getText());
			System.out.println();
			
			click_info_Hold.click();
			System.out.println("Hold Names: ");
			
			for (WebElement holdNames : HoldNames) {
				System.out.println(holdNames.getText());
			}
			
		} else {
			System.out.println("Student doesn't have Hold. Info Message not shown");
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
		wait.until(ExpectedConditions.titleContains("Higher Reach"));
	}

}
