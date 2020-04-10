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
String locator,total;
int index;
	

  @BeforeClass
  public void beforeClass() {
	  
	  String rootFolder= System.getProperty("user.dir");
	  System.setProperty("webdriver.gecko.driver",rootFolder + "\\resources\\geckodriver.exe");
	  driver= new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void TC_01_Click_To_Page() {
	  
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
  
  @Test
  public void TC_02_Click_To_Icon_By_Country() {
	  
	  driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	  
	  //remove
	  clickToIconNameByCountryName("Afghanistan","remove");
	  clickToIconNameByCountryName("Algeria","remove");
	  clickToIconNameByCountryName("Armenia","remove");
	  
	  //edit
	  clickToIconNameByCountryName("Australia","edit"); 
  }
  
  
  @Test
  public void TC_03_Get_Total_Value_By_Country() {
	  
	  driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
	  
	  total = getTotalValueByCountryName("Argentina");
	  Assert.assertEquals(total, "687522");
	  
	  
	  System.out.print(total);
  }
  
  @Test
  public void TC_04_Input_To_Textbox() {
	  driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
	  
	  //inputToTextboxByColumnNameAndRowNumber("company","2","KMS");
	  
	  inputToTextboxByColumnAndRow("Contact Person","2","KMS");
	  
	  //inputToTextboxByColumnNameAndRowNumber("name","1","JohnWick");
	  inputToTextboxByColumnAndRow("Contact Person","1","JohnWick");
	  
	  
	  //inputToTextboxByColumnNameAndRowNumber("orderPlaced","3","500");
	  inputToTextboxByColumnAndRow("Contact Person","3","500");
  }
 
  @Test
  public void TC_05_Click_Icon_By_Row() {
	  driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
	  
	  
	  //remove row 1
	  clickToIconByRowNumber("Remove","1");
	  
	  //insert row 1
	  clickToIconByRowNumber("Insert","1");
	  
	  
	  //move up row 3
	  clickToIconByRowNumber("Move Up","3");
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
  
  public void clickToIconNameByCountryName(String countryName, String iconName) {
	  locator= "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	  waitToElementClickable(driver,locator,countryName,iconName);
	  clickToElement(driver,locator,countryName,iconName);
  }
  
  public String getTotalValueByCountryName(String countryName) {
	  locator= "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total']";
	  waitToElementVisible(driver,locator,countryName);
	  return getTextElement(driver,locator,countryName);
  }
  
  public void inputToTextboxByColumnNameAndRowNumber(String columnName, String rowNumber,String value) {
	  locator= "//input[@id='tblAppendGrid_%s_%s']";
	  waitToElementVisible(driver,locator,columnName, rowNumber);
	  sendkeyToElement(driver,locator,value,columnName,rowNumber);	  
  }
  
  public void inputToTextboxByColumnAndRow(String columnName, String rowNumber, String value) {
	  locator= "//th[text()='%s']/preceding-sibling::th";
	  index= findElementsByXpath(driver,locator,columnName).size() +1;
	  locator= "//tr["+ rowNumber +"]//td["+ index +"]/input";
	  waitToElementVisible(driver,locator);
	  sendkeyToElement(driver,locator,value);	
  }
  
  public void clickToIconByRowNumber(String iconName, String rowNumber) {
	  locator= "//tbody//tr[%s]//button[contains(@title,'%s')]";
	  waitToElementClickable(driver,locator,rowNumber,iconName);
	  clickToElement(driver,locator,rowNumber,iconName);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
