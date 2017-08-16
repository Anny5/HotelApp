package ca.stqa.pft.hotelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocationPageError {
  private FirefoxDriver wd;

  @BeforeMethod
  public void setUp()throws Exception {
    wd = new FirefoxDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  @Test
  //Verification Point for text on page
  public void testGetPageErrMsg(){
    wd.get("http://www.adactin.com/HotelAppBuild2/index.php");
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys("Angytester");
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("WE589tj");
    wd.findElement(By.id("login")).click();

    wd.findElement(By.id("location")).click();
    wd.findElement(By.xpath(".//*[@id='Submit']")).click();

    String sLocationFieldError  = wd.findElement(By.xpath(".//*[@id='location_span']")).getText();
   if ( sLocationFieldError.equalsIgnoreCase("Please Select a Location"))
     System.out.println("Mandatory Error check for Location field passed. Actual location Field Error is " + sLocationFieldError);
   else
     System.out.println("Mandatory Error check for Location field didn't pass. Actual location Field Error is " + sLocationFieldError);
  }
  @AfterMethod
  public void tearDown(){
    wd.quit();
  }
  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
