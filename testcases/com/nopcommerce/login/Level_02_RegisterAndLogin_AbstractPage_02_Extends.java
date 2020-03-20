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
	  //Click to register page
	 clickToElement("//a[@class='ico-register']");
	  
	  //Verify register page is displayed  
	  Assert.assertTrue(isElementDisplayed("//div[@class='page registration-page']"));
	  
	  //click to gender radio button
	  clickToElement("//input[@id='gender-male']");
	  
	  //input FirstName
	  sendkeyToElement("//input[@id='FirstName']", "Patrick");
	  
	  //input LastName
	  sendkeyToElement("//input[@id='LastName']", "Patrick");
	  
	  //Select date of birth drop down
	  selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "12");
	  
	  //select month
	  selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "September");
	  
	  
	  //select year
	  selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1998");
	  
	  //input email
	  sendkeyToElement("//input[@id='Email']",email);
	  
	  //input company Name
	  sendkeyToElement("//input[@id='Company']","Znation");
	  
	  //input password 
	  sendkeyToElement("//input[@id='Password']","admin@123");
	  
	  
	  //input confirm password 
	  sendkeyToElement("//input[@id='ConfirmPassword']","admin@123");
	  
	  //click to register button
	  clickToElement("//input[@id='register-button']");
	 
	 
	 //verify registration complete
	 Assert.assertTrue(isElementDisplayed("//div[text()='Your registration completed']"));
	 //click to logout page
	 clickToElement("//a[@class='ico-logout']");
	 
	 //Verify User is navigated to homepage
	 Assert.assertEquals(getPageURL(), "https://demo.nopcommerce.com/");
	
  }
  @Test
  public void TC_02_Login() {
	  //click to login
	  clickToElement("//a[@class='ico-login']");
	  
	  //Verify login page is displayed
	  Assert.assertTrue(isElementDisplayed("//div[@class='page login-page']"));
	  //input email
	  sendkeyToElement("//input[@id='Email']",email);
	  
	  //input password 
	  sendkeyToElement("//input[@id='Password']","admin@123");
	  
	  //click to login button
	  clickToElement("//input[@class='button-1 login-button']");
	  
	  //verify my account link is displayed
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
