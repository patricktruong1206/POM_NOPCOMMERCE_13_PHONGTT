package com.nopcommerce.login;

import org.testng.annotations.Test;

import commons.AbstractPage;


import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Level_02_RegisterAndLogin_AbstractPage_02_Extends extends AbstractPage {
	
	public Level_02_RegisterAndLogin_AbstractPage_02_Extends(WebDriver driverLocal) {
		super(driverLocal);
	}
	WebDriver driver;
	Select select;
	String email;

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
	  }
	
  @Test
  public void TC_01_Register() {
	
	 clickToElement("//a[@class='ico-register']");
	  
 
	  Assert.assertTrue(isElementDisplayed("//div[@class='page registration-page']"));
	  

	  clickToElement("//input[@id='gender-male']");
	  

	  sendkeyToElement("//input[@id='FirstName']", "Patrick");
	  

	  sendkeyToElement("//input[@id='LastName']", "Patrick");
	  

	  selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "12");
	  
	
	  selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "September");
	  
	  

	  selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1998");
	  

	  sendkeyToElement("//input[@id='Email']",email);
	  

	  sendkeyToElement("//input[@id='Company']","Znation");
	  

	  sendkeyToElement("//input[@id='Password']","admin@123");
	  
	  

	  sendkeyToElement("//input[@id='ConfirmPassword']","admin@123");
	  

	  clickToElement("//input[@id='register-button']");
	 
	 

	 Assert.assertTrue(isElementDisplayed("//div[text()='Your registration completed']"));
	
	 clickToElement("//a[@class='ico-logout']");
	 

	 Assert.assertEquals(getPageURL(), "https://demo.nopcommerce.com/");
	
  }
  @Test
  public void TC_02_Login() {
	
	  clickToElement("//a[@class='ico-login']");
	  

	  Assert.assertTrue(isElementDisplayed("//div[@class='page login-page']"));
	  
	  sendkeyToElement("//input[@id='Email']",email);
	  

	  sendkeyToElement("//input[@id='Password']","admin@123");
	  

	  clickToElement("//input[@class='button-1 login-button']");
	  

	  Assert.assertTrue(isElementDisplayed("//a[@class='ico-account']"));
	  
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
