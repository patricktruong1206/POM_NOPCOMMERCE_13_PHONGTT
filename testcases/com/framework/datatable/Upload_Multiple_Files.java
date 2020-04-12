package com.framework.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class Upload_Multiple_Files extends AbstractTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String seleniumFileName = "Selenium.jpg";
	String appiumFileName = "Appium.jpg";
	String specflowFileName = "Specflow.jpg";

	
	@BeforeClass()
	public void beforeClass() {
		  String rootFolder= System.getProperty("user.dir");
		  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
		  driver= new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Sendkeys() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Upload 1 file
		uploadMultipleFiles(seleniumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 2 file
		uploadMultipleFiles(specflowFileName, appiumFileName);
		Thread.sleep(3000);

		// Verify
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

		driver.navigate().refresh();

		// Upload 3 file
		uploadMultipleFiles(seleniumFileName, specflowFileName, appiumFileName);
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + seleniumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + appiumFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + specflowFileName + "')]")).isDisplayed());

	}

	public void uploadMultipleFiles(String... fileNames) {
		String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		
		
		//remove blank character
		fullFileName = fullFileName.trim();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(fullFileName);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
