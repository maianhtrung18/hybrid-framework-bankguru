package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashBoardPageObject extends BasePage{

	private WebDriver driver;

	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
	}
	
	
}
