package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		BrowserFactory browserFactory = new BrowserFactory();
		ClassLoader loader = browserFactory.getClass().getClassLoader();

		switch (browserName) {
		case "FF":
			driver = drivers.get("Chrome");
			if (driver == null) {
				FirefoxProfile profile=new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true); //To handle untrusted certificate
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;

		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {
				try {
					File file = new File(loader.getResource(
							"drivers/IEDriverServer_win32_v2.48.0.exe")
							.getFile());
					System.setProperty("webdriver.ie.driver", file.getPath());

					// Create object of DesiredCapabilities class
					DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

					// Set ACCEPT_SSL_CERTS  variable to true
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //To handle untrusted certificate

					// Open browser with capability
					driver = new InternetExplorerDriver(cap);
					drivers.put("IE", driver);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;

		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {

				try {
					File file = new File(loader.getResource(
							"drivers/chromedriver_win32_v2.20.exe").getFile());
					System.setProperty("webdriver.chrome.driver", file.getPath());

					// Create object of DesiredCapabilities class
					DesiredCapabilities cap = DesiredCapabilities.chrome();

					// Set ACCEPT_SSL_CERTS  variable to true
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //To handle untrusted certificate

					// Open browser with capability
					driver = new ChromeDriver(cap);
					drivers.put("Chrome", driver);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		
		default:
			System.out.println("Browser name not matches");
			break;
		}
		return driver;
	}


	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
			}
		}
}

