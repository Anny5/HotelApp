package ca.stqa.pft.hotelapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class OrderTickets {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
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
    wd.findElement(By.linkText("Booked Itinerary")).click();
    wd.findElement(By.linkText("Search Hotel")).click();
    if (!wd.findElement(By.xpath("//*[@id='location']//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//*[@id='location']//option[4]")).click();
    }
    if (!wd.findElement(By.xpath("//*[@id='room_nos']//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//*[@id='room_nos']//option[3]"));
    }
    if (!wd.findElement(By.xpath("//*[@id='adult_room']//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//*[@id='adult_room']//option[3]")).click();
    }
    wd.findElement(By.id("Submit")).click();
    if (!wd.findElement(By.id("radiobutton_1")).isSelected()) {
      wd.findElement(By.id("radiobutton_1")).click();
    }
    wd.findElement(By.id("continue")).click();
    wd.findElement(By.id("first_name")).click();
    wd.findElement(By.id("first_name")).clear();
    wd.findElement(By.id("first_name")).sendKeys("Samanta");
    wd.findElement(By.id("last_name")).click();
    wd.findElement(By.id("last_name")).clear();
    wd.findElement(By.id("last_name")).sendKeys("Fox");
    wd.findElement(By.id("address")).click();
    wd.findElement(By.id("address")).clear();
    wd.findElement(By.id("address")).sendKeys("New York, 25 Avenue");
    wd.findElement(By.id("cc_num")).click();
    wd.findElement(By.id("cc_num")).clear();
    wd.findElement(By.id("cc_num")).sendKeys("1234567891234567");
    //added support import
    // Select dropdown by visibleText
    Select dropdown = new Select(wd.findElement(By.id("cc_type")));
    dropdown.selectByVisibleText("VISA");

    if (!wd.findElement(By.xpath("//*[@id='cc_exp_month']//option[6]")).isSelected()) {
      wd.findElement(By.xpath("//*[@id='cc_exp_month']//option[6]")).click();
    }
    if (!wd.findElement(By.xpath("//*[@id='cc_exp_year']//option[11]")).isSelected()) {
      wd.findElement(By.xpath("//*[@id='cc_exp_year']//option[11]")).click();
    }
    wd.findElement(By.id("cc_cvv")).click();
    wd.findElement(By.id("cc_cvv")).clear();
    wd.findElement(By.id("cc_cvv")).sendKeys("123");
    wd.findElement(By.id("book_now")).click();
    wd.findElement(By.id("my_itinerary")).click();
    if(!wd.findElement(By.name("ids[]")).isSelected()){
      wd.findElement(By.name("ids[]")).click();
    }
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

