package com.nopcommerce.payment;

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


public class Level_02_AbstractPage_01 {
	WebDriver driver;
	AbstractPage abstractPage;
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
	  
	  abstractPage = new AbstractPage(driver);
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  }
	
  @Test
  public void TC_01_Register() {
	  //Click to register page
	  abstractPage.clickToElement("//a[@class='ico-register']");
	  
	  //Verify register page is displayed  
	  Assert.assertTrue(abstractPage.isElementDisplayed("//div[@class='page registration-page']"));
	  
	  //click to gender radio button
	  abstractPage.clickToElement("//input[@id='gender-male']");
	  
	  //input FirstName
	  abstractPage.sendkeyToElement("//input[@id='FirstName']", "Patrick");
	  
	  //input LastName
	  abstractPage.sendkeyToElement("//input[@id='LastName']", "Patrick");
	  
	  //Select date of birth drop down
	  abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "12");
	  
	  //select month
	  abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "September");
	  
	  
	  //select year
	  abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1998");
	  
	  //input email
	  abstractPage.sendkeyToElement("//input[@id='Email']",email);
	  
	  //input company Name
	  abstractPage.sendkeyToElement("//input[@id='Company']","Znation");
	  
	  //input password 
	  abstractPage.sendkeyToElement("//input[@id='Password']","admin@123");
	  
	  
	  //input confirm password 
	  abstractPage.sendkeyToElement("//input[@id='ConfirmPassword']","admin@123");
	  
	  //click to register button
	  abstractPage.clickToElement("//input[@id='register-button']");
	 
	 
	 //verify registration complete
	 Assert.assertTrue(abstractPage.isElementDisplayed("//div[text()='Your registration completed']"));
	 //click to logout page
	  abstractPage.clickToElement("//a[@class='ico-logout']");
	 
	 //Verify User is navigated to homepage
	 Assert.assertEquals(abstractPage.getPageURL(), "https://demo.nopcommerce.com/");
	
  }
  @Test
  public void TC_02_Login() {
	  //click to login
	  abstractPage.clickToElement("//a[@class='ico-login']");
	  
	  //Verify login page is displayed
	  Assert.assertTrue(abstractPage.isElementDisplayed("//div[@class='page login-page']"));
	  //input email
	  abstractPage.sendkeyToElement("//input[@id='Email']",email);
	  
	  //input password 
	  abstractPage.sendkeyToElement("//input[@id='Password']","admin@123");
	  
	  //click to login button
	  abstractPage.clickToElement("//input[@class='button-1 login-button']");
	  
	  //verify my account link is displayed
	  Assert.assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account']"));
	  
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
