package com.nopcommerce.login;

import org.testng.annotations.Test;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
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


public class Level_07_RegisterAndLogin_Factory_Pattern extends AbstractTest{
	WebDriver driver;
	Select select;
	String email;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DriverManager driverManager;
	
	
  @Parameters("browser") 	
  @BeforeClass
  public void beforeTest(String browserName) {
	
	  //driver = getBrowserDriver(browserName);
	  
	  driverManager = DriverManagerFactory.getBrowserManager(browserName);
	  driver = driverManager.getBrowserDriver();
	  
	
	  email= "Burner"+ randomNumber()+"@gmail.com";

	  }
	
  @Test
  public void TC_01_Register() {
	  
	  homePage = PageGeneratorManager.getHomePage(driver);
	  homePage.clickToRegisterLink();
	  registerPage= PageGeneratorManager.getRegisterPage(driver);
	  
	  registerPage.clickToMaleButton();
	  
	  registerPage.inputToFirstNameTextbox("John");
	  
	  registerPage.inputToLastNameTextbox("Wick");
	  
	  registerPage.inputToEmailTextbox(email);
	  
	  registerPage.inputToPasswordTextbox("123456");
	  
	  registerPage.inputToConfirmPasswordTextbox("123456");
	  
	  registerPage.clickToRegisterButton();
	  
	  assertTrue(registerPage.isSuccessMesageDisplayed());
	  
	  registerPage.clickToLogout();
	  
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  
	  
	  
	
  }
  @Test
  public void TC_02_Login() {
	  
	  homePage.clickToLoginLink();
	  loginPage= PageGeneratorManager.getLoginPage(driver);
	  
	  loginPage.inputToEmailTextbox(email);
	  
	  loginPage.inputToPasswordTextbox("123456");
	  
	  loginPage.clickToLoginButton();
	  
	  homePage= PageGeneratorManager.getHomePage(driver);
	  
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
