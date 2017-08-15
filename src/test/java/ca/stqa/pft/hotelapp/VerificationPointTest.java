package ca.stqa.pft.hotelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerificationPointTest {
 private FirefoxDriver wd;
 private boolean acceptNextAlert = true;
// private StirngBuffer verificationErrors = new StirngBuffer();
  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  @Test
  public void testOrderTickets() {
    wd.get("http://www.adactin.com/HotelAppBuild2/index.php");
    wd.findElement(By.id("username")).click();
    wd.findElement(By.id("username")).clear();
    wd.findElement(By.id("username")).sendKeys("Angytester");
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("WE589tj");
    wd.findElement(By.id("login")).click();

    new Select(wd.findElement(By.id("location"))).selectByVisibleText("Sydney");
    wd.findElement(By.id("Submit")).click();
    String slocation = wd.findElement(By.xpath(".//*[@id='location_1']")).getAttribute("value");

    if (slocation.equalsIgnoreCase("Sydney"))
      System.out.println("The Search Results are correct");
      else
      System.out.println("The Search Results are incorrect");
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

