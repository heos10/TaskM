/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author huliv
 */
public class Registration {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/LoginWebApp/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegistration() throws Exception {
    driver.get(baseUrl + "/LoginWebApp/");
    driver.findElement(By.linkText("Register here")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("heos");
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("hugo");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("soares");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("heos@ua.pt");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("heos");
    driver.findElement(By.id("password_confirmation")).clear();
    driver.findElement(By.id("password_confirmation")).sendKeys("heos");
    driver.findElement(By.xpath("//input[@value='Register']")).click();
    assertEquals("Registration Successful!", closeAlertAndGetItsText());
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