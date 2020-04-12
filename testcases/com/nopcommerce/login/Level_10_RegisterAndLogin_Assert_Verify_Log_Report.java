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
import org.testng.annotations.Optional;
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


import org.testng.annotations.AfterClass;


public class Level_10_RegisterAndLogin_Assert_Verify_Log_Report extends AbstractTest{
	private WebDriver driver;
	private HomePageObject homePage;

  @Parameters("browser") 	
  @BeforeClass
  public void beforeTest(@Optional("chrome")String browserName) {
	
	  driver = getBrowserDriver(browserName);
	  homePage= PageGeneratorManager.getHomePage(driver);
	 
	  }
	
  @Test
  public void TC_01_Assert() {
	log.info("TC_01 - Step 01: Open new customer page");
	
	log.info("TC_01 - Step 02: Verify new customer displayed");
	Assert.assertTrue(true);
	
	log.info("TC_01 - Step 03 Verfiy new customer form not  displayed");
	Assert.assertTrue(false);
	
	log.info("TC_01 - Step 04: Verify homapage not displayed");
	Assert.assertTrue(true);
	
  }
  
  
  @Test
  public void TC_02_Verify() {
	  	log.info("TC_02 - Step 01: Open new customer page");
		
	  	log.info("TC_02 - Step 02: Verify new customer displayed");
		verifyTrue(true);
		
		log.info("TC_02 - Step 03 Verfiy new customer form not  displayed");
		verifyTrue(false);
		
		log.info("TC_02 - Step 04: Verify homapage not displayed");
		verifyTrue(true);
		
		log.info("TC_02 - Step 05 Verfiy new customer form not  displayed");
		verifyTrue(false);
	  
  }
 
  



  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
