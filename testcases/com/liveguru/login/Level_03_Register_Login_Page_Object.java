package com.liveguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveguru.HomePageObject;
import pageObject.liveguru.LoginPageObject;
import pageObject.liveguru.MyDashBoardPageObject;

public class Level_03_Register_Login_Page_Object extends BaseTest {
	WebDriver driver;
	String appUrl;
	String emailAddress, password;

	@Parameters({"browser","appURL"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		
	
		driver= getBrowserDriver(browserName);
		driver.get(appUrl);
		emailAddress = getRandomEmail();
		password = "123456";
		
		
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		// step 1: mowr url
	
		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurentPage(driver);

		loginPage.enterToEmailTextbox("da@gg");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(),
				"Please enter a valid email address. For example johndoe@domain.com.");

	}

	@Test(description = "password less than 6 characters")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurentPage(driver);

		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("12345");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_05_Incorrect_Password() {

		loginPage.refreshCurentPage(driver);

		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("1112222");
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurentPage(driver);

		loginPage.enterToEmailTextbox("dam@gmail.com");
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboardPage = new MyDashBoardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(9999999) + "@gmail.com";
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashboardPage;

}
