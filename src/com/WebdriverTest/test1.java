package com.WebdriverTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.bin","D:\\SoftwareTesting\\firefox2\\firefox.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNew1() throws Exception {
	List<String> dataList=csvreader.importCsv(new File("D:\\SoftwareTesting\\inputgit.csv"));
	String data,gitURL;
	for(int i=1;i<dataList.size()-1;i++){
   		data = dataList.get(i);
   		int urlLocation = data.lastIndexOf(",");
        if(data.charAt(14) == ','){
        	gitURL = data.substring(urlLocation+1,data.length());
        }
        else{
        	gitURL = data.substring(urlLocation+1,data.length());
        }
        driver.get(baseUrl + "/");
    	driver.findElement(By.id("name")).clear();
    	driver.findElement(By.id("name")).sendKeys(data.substring(0,10));
    	driver.findElement(By.id("pwd")).clear();
    	driver.findElement(By.id("pwd")).sendKeys(data.substring(4,10));
    	driver.findElement(By.id("submit")).click();
    	assertEquals(gitURL, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
   	}
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
