package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProgramCatalogsPage extends BasePage {

	public ProgramCatalogsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "img[title='Catalog list']")
	public WebElement catalog_list;
	
	@FindBy(how = How.CSS, using = "img[title='Catalog grid']")
	public WebElement catalog_grid;
	
	@FindBy(how = How.CSS, using = "#catalogTarget a[href^='index.html?action=programBrowse&CatalogID=']")
	public List<WebElement> catalog_links = new ArrayList<WebElement>();
	
	
	public void getCatalogs() throws InterruptedException{
		clickAction(catalog_list);
		wait.until(ExpectedConditions.visibilityOfAllElements(catalog_links));
		System.out.println("Number of Program Catalogs: " + catalog_links.size());
		System.out.println("Program Catalog Listings:");
		System.out.println();
		for (WebElement catalog : catalog_links) {
			System.out.println(catalog.getText());
		}
		System.out.println();
		getInfo();
		System.out.println();
	}
	

	/*public void LogIn_Action(Map<String, String> data) {
		sendKeysAction(txtbx_Login, data.get("UserName"));
		sendKeysAction(txtbx_Password, data.get("Password"));
		clickAction(btn_Login);
	}*/
}
