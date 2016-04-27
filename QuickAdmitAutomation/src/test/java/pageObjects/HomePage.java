package pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		waitForLoad(driver);
	}

	@FindBy(how = How.CSS, using = "a[href='shop/index.html']")
	public WebElement btn_StudentView;
	
	@FindBy(how = How.CSS, using = "a[href='affiliate/index.html']")
	public WebElement btn_AffiliateView;
	
	@FindBy(how = How.CSS, using = "a[href='instructor/index.html']")
	public WebElement btn_InstructorView;
	
	public CourseCatalogsPage BrowseStudentView_Action() throws InterruptedException {
		clickAction(btn_StudentView);
		waitForLoad(driver);
		return PageFactory.initElements(driver, CourseCatalogsPage.class);
	}
	
	public void BrowseAffiliateView_Action() {
		waitForLoad(driver);
		clickAction(btn_AffiliateView);
		waitForLoad(driver);
	}
	
	public void BrowseInstructorView_Action() {
		waitForLoad(driver);
		clickAction(btn_InstructorView);
		waitForLoad(driver);
	}

}
