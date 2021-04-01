package pageObject.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage{

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String email) {
		waitForAllElementsVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, email);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getEmptyEmailErrorMessage() {
		waitForAllElementsVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		
	}

	public String getEmptyPasswordErrorMessage() {
		waitForAllElementsVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	}



	public String getInvalidEmailOrPasswordErrorMessage() {
		waitForAllElementsVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	}

	public String getInvalidPasswordErrorMessage() {
		waitForAllElementsVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}
	
	public String getInvalidEmailErrorMessage() {
		waitForAllElementsVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	}
	
	
}
