package com.nopcommerce.login;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterToSystem;

import commons.AbstractPages;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.FooterMyAccountPageObject;
import pageObjects.FooterNewProductPageObject;
import pageObjects.FooterSearchPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;


public class Level_11_Register_ShareClassState extends AbstractTest{
	WebDriver driver;
	Select select;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage;
  @Parameters("browser") 	
  @BeforeClass
  public void beforeTest(String browserName) {
	
	  driver = getBrowserDriver(browserName);
	  homePage= PageGeneratorManager.getHomePage(driver);
	  
	  homePage.clickToLoginLink();
	  loginPage= PageGeneratorManager.getLoginPage(driver);
	  
	  loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.email);
	  
	  loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.password);
	  
	  loginPage.clickToLoginButton();
	  
	  homePage= PageGeneratorManager.getHomePage(driver);
	  
	  assertTrue(homePage.isMyAccountLinkDisplayed());
	  assertTrue(homePage.isLogOutLinkDisplayed());
	  

	  }
	
  
  @Test
  public void TC_01_ViewProduct() {
	  

	  
	
  }
  
  
  @Test
  public void TC_02_Order() {
	
  }
  
  @Test
  public void TC_03_Oayment() {
	
  }
  
  

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  closeBrowserAndDriver(driver);
  }
  
}
