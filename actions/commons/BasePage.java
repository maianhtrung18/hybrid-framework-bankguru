package commons;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
 
	public void clickElement(WebDriver driver ,String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	public String getPageUrl(WebDriver driver){
		return driver.getCurrentUrl();	
	}
	
	public void openPageUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageSource(WebDriver driver){
		return driver.getPageSource();
	}
	
	public Alert waiForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeOutInSecond);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = waiForAlertPresent(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waiForAlertPresent(driver);
		alert.dismiss();
	}
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waiForAlertPresent(driver);
		alert.sendKeys(value);
	}
	
	public String getAlertText(WebDriver driver) {
		alert = waiForAlertPresent(driver);
		return alert.getText();
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			if (!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String windowID : allWindowIDs) {
			driver.switchTo().window(windowID);
			String actualWindowTitle = driver.getTitle();
			if (actualWindowTitle.equals(expectedWindowTitle)) {
				break;
			}
			
		}
	}
	
	public void closeAllWindowExceptedParent(WebDriver driver, String parentID) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String windowID : allWindowID) {
			if(!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				driver.close();
				sleepInSecond(1);
			}
			if (driver.getWindowHandles().size()==1) {
				driver.switchTo().window(parentID);
				break;
			}
		}
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	private Alert alert;
	private WebDriverWait explicitWait;
	private long timeOutInSecond = 30;
}
