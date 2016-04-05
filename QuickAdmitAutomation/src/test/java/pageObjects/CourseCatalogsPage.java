package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CourseCatalogsPage extends BasePage {

	public CourseCatalogsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "img[title='Catalog list']")
	public WebElement catalog_list;
	
	@FindBy(how = How.CSS, using = "img[title='Catalog grid']")
	public WebElement catalog_grid;
	
	@FindBy(how = How.CSS, using = "#catalogTarget a[onclick^='forwardToCourseBrowse']")
	public List<WebElement> catalog_links = new ArrayList<WebElement>();
	
	
	
	public void getCatalogs() throws InterruptedException{
		clickAction(catalog_list);
		wait.until(ExpectedConditions.visibilityOfAllElements(catalog_links));
		System.out.println("Number of Course Catalogs: " + catalog_links.size());
		System.out.println("Course Catalog Listings:");
		System.out.println();
		for (WebElement catalog : catalog_links) {
			System.out.println(catalog.getText());
		}
		
		System.out.println();
//		getInfo();
		System.out.println();
	}

	/*public void LogIn_Action(Map<String, String> data) {
		sendKeysAction(txtbx_Login, data.get("UserName"));
		sendKeysAction(txtbx_Password, data.get("Password"));
		clickAction(btn_Login);
	}*/
}
