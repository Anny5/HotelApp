package ca.stqa.pft.hotelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetPageTitle {
 private FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  @Test
  public void testGetTitle1() {
    wd.get("http://www.adactin.com/HotelAppBuild2/index.php");
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys("Angytester");
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("WE589tj");
    wd.findElement(By.id("login")).click();

    String spageTitle = wd.getTitle();
      System.out.println("Your page title is: " + spageTitle);
     if (spageTitle.equalsIgnoreCase("AdactIn.com - Search Hotel"))
       System.out.println("Page title is correct. Actual page title is " + spageTitle );
     else
       System.out.println("\"Page title is correct. Actual page title is " + spageTitle);
    }

    @AfterMethod
    public void tearDown() {
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

