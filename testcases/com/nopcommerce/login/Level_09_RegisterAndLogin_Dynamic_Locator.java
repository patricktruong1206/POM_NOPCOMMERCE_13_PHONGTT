package com.nopcommerce.login;

import org.testng.annotations.Test;

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


public class Level_09_RegisterAndLogin_Dynamic_Locator extends AbstractTest{
	WebDriver driver;
	Select select;
	String email;
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
  
  
  @Test(description = "Only use in case less page")
  public void TC_03_Dynamic_Less() {
	//Homepage -> (My Account) footer
	  myAccountPage= (FooterMyAccountPageObject) homePage.openFooterPageByName(driver,"My account");
	  
	//My account -> Search
	  searchPage= (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver,"Search");
	  
	  //Search - > New product
	  newProductPage= (FooterNewProductPageObject) searchPage.openFooterPageByName(driver,"New products");
	  
	  // New product =>  Homepage
	  homePage= newProductPage.openHomePage(driver);
	  
	  //Homepage => Search
	  searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver,"Search");
	
	  //Search => My Account
	  myAccountPage= (FooterMyAccountPageObject) searchPage.openFooterPageByName(driver,"My account");
	  
	  //My Account => New products
	  newProductPage= (FooterNewProductPageObject) myAccountPage.openFooterPageByName(driver,"New products");
	  
	  //New product => search
	  searchPage= (FooterSearchPageObject) newProductPage.openFooterPageByName(driver,"Search");
  }
  
  @Test(description = "Only use in case too many page")
  public void TC_04_Dynamic_More() {
	//New product-> (My Account) footer
	  newProductPage.openFooterPagesByName(driver,"My account");
	  myAccountPage=PageGeneratorManager.getFooterMyAccountPage(driver);
	  
	//My account -> Search
	 myAccountPage.openFooterPagesByName(driver,"Search");
	 searchPage= PageGeneratorManager.getFooterSearch(driver);
	  
	  //Search - > New product
	   searchPage.openFooterPagesByName(driver,"New products");
	   newProductPage= PageGeneratorManager.getFooterNewProductPage(driver);
	  
	  // New product =>  Homepage
	  homePage= newProductPage.openHomePage(driver);
	  
	  //Homepage => Search
	   homePage.openFooterPagesByName(driver,"Search");
	   searchPage= PageGeneratorManager.getFooterSearch(driver);
	
	  //Search => My Account
	    searchPage.openFooterPagesByName(driver,"My account");
	    myAccountPage=PageGeneratorManager.getFooterMyAccountPage(driver);
	  
	  //My Account => New products
	  myAccountPage.openFooterPagesByName(driver,"New products");
	  newProductPage= PageGeneratorManager.getFooterNewProductPage(driver);
	  
	  //New product => search
	 newProductPage.openFooterPagesByName(driver,"Search");
	 searchPage= PageGeneratorManager.getFooterSearch(driver);
	  
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
