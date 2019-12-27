package com.nopcommerce.payment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Level_01_Step_By_Step {
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
	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  }
	
  @Test
  public void TC_01_Register() {
	  //Click to register page
	  driver.findElement(By.xpath("//a[@class='ico-register']")).click();
	  
	  //Verify register page is displayed
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());
	  
	  //click to gender radio button
	  driver.findElement(By.xpath("//input[@id='gender-male']")).click();
	  
	  //input FirstName
	  driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Patrick");
	  
	  //input LastName
	  driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Burner");
	  
	  //Select date of birth drop down
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
	  select.selectByVisibleText("12");
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
	  select.selectByVisibleText("September");
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
	  select.selectByVisibleText("1998");
	  
	  //input email
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  
	  //input company Name
	  driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Znation");
	  
	  //input password 
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin@123");
	  
	  //input confirm password 
	  driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("admin@123");
	  
	  //click to register button
	 driver.findElement(By.xpath("//input[@id='register-button']")).click();
	 
	 //verify registration complete
	 Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());
	 
	 //click to logout page
	 driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	 
	 //Verify User is navigated to homepage
	 Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
  }
  @Test
  public void TC_02_Login() {
	  //click to login
	  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	  
	  //Verify login page is displayed
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());
	  
	  //input email
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  
	  //input password 
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin@123");
	  
	  //click to login button
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	  
	  //verify my account link is displayed
	  Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed());
	  
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
