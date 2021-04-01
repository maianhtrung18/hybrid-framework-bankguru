package commons;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");

	public enum BROWSER {FIREFOX, CHROME};
	
	public WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
			
		if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + getDirectorySlash("browserDrivers") + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + getDirectorySlash("browserDrivers") +"chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver getBrowserDriver(String browserName, String appUrl) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectLocation + getDirectorySlash("browserDrivers") + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectLocation + getDirectorySlash("browserDrivers") + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		separator = File.separator;
		return separator + folderName +separator;
	}

}
