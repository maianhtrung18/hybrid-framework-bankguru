package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static MyDashBoardPageObject getMyDashBoardPage(WebDriver driver) {
		return new MyDashBoardPageObject(driver);
	}

}
