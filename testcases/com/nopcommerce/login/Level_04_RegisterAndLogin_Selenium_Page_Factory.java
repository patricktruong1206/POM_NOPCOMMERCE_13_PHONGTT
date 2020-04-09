package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractPageFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;


public class Level_04_RegisterAndLogin_Selenium_Page_Factory {
	WebDriver driver;
	Select select;
	String email;
	private HomePageFactory homePage;
	private RegisterPageFactory registerPage;
	private LoginPageFactory loginPage;

  @BeforeClass
  public void beforeClass() {
	  String rootFolder= System.getProperty("user.dir");
	  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
	  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
	  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
	  
	  email= "Burner"+ randomNumber()+"@gmail.com";
	  driver= new FirefoxDriver();
	  
	  //driver = ID
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  homePage = new HomePageFactory(driver);
	  }
	
  @Test
  public void TC_01_Register() {
	  homePage.clickToRegisterLink();
	  registerPage= new RegisterPageFactory(driver);
	  
	  registerPage.clickToMaleButton();
	  
	  registerPage.inputToFirstNameTextbox("John");
	  
	  registerPage.inputToLastNameTextbox("Wick");
	  
	  registerPage.inputToEmailTextbox(email);
	  
	  registerPage.inputToPasswordTextbox("123456");
	  
	  registerPage.inputToConfirmPasswordTextbox("123456");
	  
	  registerPage.clickToRegisterButton();
	  
	  assertTrue(registerPage.isSuccessMesageDisplayed());
	  
	  registerPage.clickToLogout();
	  
	  homePage= new HomePageFactory(driver);
	  
	  
	  
	  
	
  }
  @Test
  public void TC_02_Login() {
	  
	  homePage.clickToLoginLink();
	  loginPage= new LoginPageFactory(driver);
	  
	  loginPage.inputToEmailTextbox(email);
	  
	  loginPage.inputToPasswordTextbox("123456");
	  
	  loginPage.clickToLoginButton();
	  
	  homePage= new HomePageFactory(driver);
	  
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
