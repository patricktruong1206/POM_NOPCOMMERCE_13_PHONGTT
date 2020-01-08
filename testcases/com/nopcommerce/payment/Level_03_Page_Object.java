package com.nopcommerce.payment;

import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;


public class Level_03_Page_Object {
	WebDriver driver;
	Select select;
	String email;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

  @BeforeClass
  public void beforeClass() {
	  String rootFolder= System.getProperty("user.dir");
	  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver 0.25.exe");
	  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
	  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
	  
	  email= "Burner"+ randomNumber()+"@gmail.com";
	  driver= new FirefoxDriver();
	  
	  //driver = ID
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  homePage = new HomePageObject(driver);
	  }
	
  @Test
  public void TC_01_Register() {
	  homePage.clickToRegisterLink();
	  registerPage= new RegisterPageObject(driver);
	  
	  registerPage.clickToMaleButton();
	  
	  registerPage.inputToFirstNameTextbox("John");
	  
	  registerPage.inputToLastNameTextbox("Wick");
	  
	  registerPage.inputToEmailTextbox(email);
	  
	  registerPage.inputToPasswordTextbox("123456");
	  
	  registerPage.inputToConfirmPasswordTextbox("123456");
	  
	  registerPage.clickToRegisterButton();
	  
	  assertTrue(registerPage.isSuccessMesageDisplayed());
	  
	  registerPage.clickToLogout();
	  
	  homePage= new HomePageObject(driver);
	  
	  
	  
	  
	
  }
  @Test
  public void TC_02_Login() {
	  
	  homePage.clickToLoginLink();
	  loginPage= new LoginPageObject(driver);
	  
	  loginPage.inputToEmailTextbox(email);
	  
	  loginPage.inputToPasswordTextbox("123456");
	  
	  loginPage.clickToLoginButton();
	  
	  homePage= new HomePageObject(driver);
	  
	  assertTrue(homePage.isMyAccountLinkDisplayed());
	  assertTrue(homePage.isLogOutLinkDisplayed());
	  
	
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random random= new Random();
	  return random.nextInt(1000);
  }
}
