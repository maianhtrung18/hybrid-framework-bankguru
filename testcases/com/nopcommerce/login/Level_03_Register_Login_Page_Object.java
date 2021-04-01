package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopcommerce.HomePageObject;
import pageObject.nopcommerce.LoginPageObject;
import pageObject.nopcommerce.PageGeneratorManager;
import pageObject.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Register_Login_Page_Object extends BaseTest{
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	String emailAddress, password;
  
  @BeforeClass
  @Parameters({"browser"})
  public void initBrowser(String browserName) {
		System.setProperty("webdriver.gecko.driver", projectLocation + "/browserDrivers/geckodriver.exe");

		this.driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		emailAddress =  getRandomEmail();
		password = "123456";
		homePage = PageGeneratorManager.getHomePage(driver);
	}
  @Test
  public void Login_01_Register_To_System() {
	  
	  //Step 2 : Verify homepage slider displayed
	  Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	  
	  //Step 3 : click to register link 
	  registerPage = homePage.clickToRegisterLink();
	  
		
	  //Step 4 : Click to Gender male ratio
	  registerPage.clickToGenderMailRadioButton();
	  
	  //Step 5 : input to first name textbox
	  registerPage.enterToFirstNameTextbox("Mai");
	  
	  //step 6: Input to last name text box
	  registerPage.enterToLastNameTextbox("Mai");
	  
	  //Step 7 :Input to Email text box
	  registerPage.enterToEmailTextbox(emailAddress);
	  
	  //Step 8 : Input to password text box
	  registerPage.enterToPasswordTextbox(password);
	  
	  //Step 9 : Input to confirm password text box
	  registerPage.enterToConfirmPasswordTextbox(password);
	  
	  //Step 10 : click to register button
	  registerPage.clickToRegisterButton();
	  
	  //Step 11: Verify Success message displayed
	  Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
	  
	  //Step 12: click to logout link
	  registerPage.clickToLogoutLink();
	  
	  
	  //Step 13 : Verify homepage logo displayed
	  Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
  
  @Test
  public void Login_02_Login_To_System() {
	  //Step 1 : Click to login link
	  loginPage = homePage.clickToLoginLink();
	  
	  
	  //Step 2 : Input to email textbox
	  loginPage.enterToEmailTextbox(emailAddress);
	  
	  //Step 3: Input to password textbox
	  loginPage.enterToPasswordTextbox(password);
	  
	  //Step 4 : click to login button
	  homePage = loginPage.clickToLoginButton();
	  
	  
	  //Step 5 : Verify homepage logo displayed
	  Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	  
  }
  
  HomePageObject homePage;
  LoginPageObject loginPage;
  RegisterPageObject registerPage;

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public String getRandomEmail() {
	  Random rand = new Random();
	  return "testing" + rand.nextInt(9999999) + "@gmail.com";
  }

}
