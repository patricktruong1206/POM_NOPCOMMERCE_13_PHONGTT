package com.framework.datatable;

import org.testng.annotations.Test;

import commons.AbstractPages;


import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Handle_Dynamic_DataTable_Grid extends AbstractPages{
WebDriver driver;
String locator;
	

  @BeforeClass
  public void beforeClass() {
	  
	  String rootFolder= System.getProperty("user.dir");
	  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
	  driver= new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void TC_01() {
	  
	  driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	  
	  
	  //5
	  
	  goToPageByNumber("5");
	  Assert.assertTrue(isPageActiveByPageNumber("5"));
	  
	  //10
	  goToPageByNumber("10");
	  Assert.assertTrue(isPageActiveByPageNumber("10"));
	  
	  //15
	  goToPageByNumber("15");
	  Assert.assertTrue(isPageActiveByPageNumber("15"));
	  
  }
  
  
  //Go to page by page number
  
  public void goToPageByNumber(String pageNumber) {
	  
	  //interface - PageUI
	  locator= "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	  waitToElementClickable(driver,locator,pageNumber);
	  clickToElement(driver,locator,pageNumber);
  }
  
  
  public boolean isPageActiveByPageNumber(String pageNumber) {
	  locator= "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	  waitToElementVisible(driver,locator,pageNumber);
	  return isElementDisplayed(driver,locator,pageNumber);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
