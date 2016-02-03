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
import org.openqa.selenium.ie.InternetExplorerDriver;

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
			driver = drivers.get("Firefox");
			if (driver == null) {
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;

		case "IE":
			driver = drivers.get("IE");
			if (driver == null) {

				// File file = new File("IEDriverServer_win32_v2.48.0.exe");
				// System.setProperty("webdriver.ie.driver", file.getPath());
				// System.setProperty("webdriver.ie.driver",
				// "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");

				try {
					File file = new File(loader.getResource(
							"drivers/IEDriverServer_win32_v2.48.0.exe")
							.getFile());
					System.setProperty("webdriver.ie.driver", file.getPath());
				} catch (Exception e) {
					e.printStackTrace();
				}

				driver = new InternetExplorerDriver();
				drivers.put("IE", driver);
			}
			break;

		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {

				try {
					File file = new File(loader.getResource(
							"drivers/chromedriver_win32_v2.20.exe").getFile());
					System.setProperty("webdriver.chrome.driver",
							file.getPath());
				} catch (Exception e) {
					e.printStackTrace();
				}

				// System.setProperty("webdriver.chrome.driver",
				// "C:\\Users\\abc\\Desktop\\Server\\ChromeDriver.exe");
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
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
