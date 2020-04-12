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

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;


public class Level_10_RegisterAndLogin_Assert_Undisplayed extends AbstractTest{
	WebDriver driver;
	WebElement element;
	Select select;
	String email;
	Date date;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
  @Parameters("browser") 	
  @BeforeClass
  public void beforeTest(String browserName) {
	
	  driver = getBrowserDriver(browserName);
	  email= "Burner"+ randomNumber()+"@gmail.com";
	  homePage = PageGeneratorManager.getHomePage(driver);
	  }
	
  @Test(description= "Check element displayed")
  public void TC_01_CheckDisplayed() {
	  registerPage= homePage.clickToRegisterLink();
	  
	  //firstname is displayed
	  registerPage.isFirstNameTextboxDisplayed();
  }
  
  @Test
  public void TC_02_CheckUnDisplayed_In_DOM() {
	  //Request verification token undisplayed (Visbile in DOM)
	  Assert.assertTrue(registerPage.isRequestVerifyTokenTextboxUnDisplayed());	  	  
	  Assert.assertFalse(registerPage.isRequestVerifyTokenTextboxDisplayed());	 
  }
  
  @Test()
  public void TC_03_CheckUnDisplayed_NOT_In_DOM() {
	  //Undisplayed (Not visible in DOM)
	  
	  Assert.assertTrue(registerPage.isRegisterButtonUnDisplayed());	   
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
