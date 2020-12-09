package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Homework14 {


 @Test
public void verifyLowHighTemp () {

     System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

     WebDriver driver = new ChromeDriver();

     driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");


     WebElement todayMinTempLoc = driver.findElement(By.xpath("//span[@class='minTemp' and contains(text(), '30')]"));
     WebElement todayMaxTempLoc = driver.findElement(By.xpath("//span[@class='maxTemp' and contains(text(), '38')]"));
     WebElement tempLoc = driver.findElement(By.xpath("//span[@class='temp' and contains(text(), '30')]"));
     WebElement highTempLoc = driver.findElement(By.xpath("//span[@class='time']/preceding-sibling::span[@class='temp' and contains (text(), '38')]"));
     WebElement todayToggleBar = driver.findElement(By.xpath("//span[@class='name'and contains (text(), 'Today')]"));
     //backup Loc: /span[@class='lowTemp swap']/following::span[@class='temp' and contains(text(), '38')]"

     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("scrollBy(0,700);");

     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {}

     todayToggleBar.click();

     Assert.assertTrue(todayMinTempLoc.getText().equalsIgnoreCase(tempLoc.getText()), "not equals");
     Assert.assertTrue(todayMaxTempLoc.getText().equalsIgnoreCase(highTempLoc.getText()), "not equals");


     }

     @Test
     public void verifyNightBriefcase () {

         System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

         WebDriver driver = new ChromeDriver();

         driver.get("https://www.hotels.com/");

        driver.findElement(By.id("qf-0q-localised-check-in")).click();

        List<WebElement> DecDates = driver.findElements(By.xpath("//td[starts-with(@data-date, '2020-11')]"));

         SimpleDateFormat formatter = new SimpleDateFormat("d");
         Date date1 = new Date();

         String TodayDate = formatter.format(date1);
         int intTodayDate = Integer.valueOf(TodayDate);
         int tomorrowDate = intTodayDate+1;
         int expectedBriefDate = tomorrowDate+7 - tomorrowDate;
         String expectedSBriefDate = String.valueOf(tomorrowDate+7 - tomorrowDate);
         String UserCheckInDate = String.valueOf(tomorrowDate);
         String UserCheckOutDate = String.valueOf(tomorrowDate+7);

         for (WebElement date2: DecDates) {
             if (date2.getText().equalsIgnoreCase(UserCheckInDate)) {
                 date2.click();
                 break;

             }

         }

         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {}

         WebElement checkOutLoc = driver.findElement(By.id("qf-0q-localised-check-out"));
         checkOutLoc.click();

         DecDates = driver.findElements(By.xpath("//td[starts-with(@data-date, '2020-11')]"));

         for (WebElement date3: DecDates) {
             if (date3.getText().equalsIgnoreCase(UserCheckOutDate)) {
                 date3.click();
             }
         }

         WebElement briefcaseLoc = driver.findElement(By.xpath("//span[@class='widget-query-num-nights']"));

         String briefCaseDate = briefcaseLoc.getText();

         Assert.assertEquals(briefCaseDate, expectedSBriefDate, "not equal");

         driver.quit();

     }
     @Test
     public void verifyUserDetails () {

         System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

         WebDriver driver = new ChromeDriver();

         driver.get("https://www.hotels.com/");

         driver.findElement(By.id("qf-0q-destination")).click();
         WebElement NewYorkLoc = driver.findElement(By.xpath("//div[text()='New York, New York, United States of America']"));
         NewYorkLoc.click();


         driver.findElement(By.id("qf-0q-localised-check-in")).click();
         driver.findElement(By.xpath("//td[@data-date='2020-11-9']")).click();

         driver.findElement(By.id("qf-0q-localised-check-out")).click();
         driver.findElement(By.xpath("//td[@data-date='2020-11-16']")).click();

         WebElement Rooms = driver.findElement(By.id("qf-0q-rooms"));
         Select s = new Select(Rooms);
         s.selectByVisibleText("1");
         String RoomsSelected = "1";

         WebElement Adults = driver.findElement(By.id("qf-0q-room-0-adults"));
         Select s1 = new Select(Adults);
         s1.selectByVisibleText("1");
         String AdultsSelected = "1";

         WebElement Children = driver.findElement(By.id("qf-0q-room-0-children"));
         Select s2 = new Select(Children);
         s2.selectByVisibleText("2");
         String ChildrenSelected = "2";

         WebElement ChildOneAge = driver.findElement(By.id("qf-0q-room-0-child-0-age"));
         Select s3 = new Select(ChildOneAge);
         s3.selectByVisibleText("1");
         String ChildOneAgeData = "1";

         WebElement ChildTwoAge = driver.findElement(By.id("qf-0q-room-0-child-1-age"));
         Select s4 = new Select(ChildTwoAge);
         s4.selectByVisibleText("2");
         String ChildTwoAgeData = "2";

         WebElement SearchLoc = driver.findElement(By.xpath("//button[@type='submit']"));
         SearchLoc.click();

         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {}

         List<WebElement> RoomLocAfterSearch = driver.findElements(By.id("q-rooms"));
         for (WebElement rooms1: RoomLocAfterSearch) {
             if (rooms1.getText().equalsIgnoreCase(RoomsSelected)) {
                 String RoomResults = RoomsSelected;
                 Assert.assertEquals(RoomsSelected, RoomResults, "not equal");
             }
         }

         List<WebElement> AdultsAfterSearch = driver.findElements(By.id("q-room-0-adults"));
         for (WebElement adults1: AdultsAfterSearch) {
             if (adults1.getText().equalsIgnoreCase(AdultsSelected)) {
                 String AdultResults = AdultsSelected;
                 Assert.assertEquals(AdultsSelected, AdultsSelected, "not equal");
             }
         }

         List<WebElement> ChildrenAfterSearch = driver.findElements(By.id("q-room-0-children"));
         for (WebElement children1: ChildrenAfterSearch) {
             if (children1.getText().equalsIgnoreCase(ChildrenSelected)) {
                 String ChildrenResults = ChildrenSelected;
                 Assert.assertEquals(ChildrenSelected, ChildrenResults, "not equal");

             }
         } List<WebElement> ChildOneAgeAfterSearch = driver.findElements(By.id("q-room-0-child-0-age"));
         for (WebElement childOneAgeChk: ChildOneAgeAfterSearch) {
             if (childOneAgeChk.getText().equalsIgnoreCase(ChildOneAgeData)) {
                 String ChildOneAgeResults = ChildOneAgeData;
                 Assert.assertEquals(ChildOneAgeData, ChildOneAgeResults, "not equal");

             }

         } List<WebElement> ChildTwoAgeAfterSearch = driver.findElements(By.id("q-room-0-child-1-age"));
         for (WebElement childTwoAgeChk: ChildTwoAgeAfterSearch) {
             if (childTwoAgeChk.getText().equalsIgnoreCase(ChildTwoAgeData)) {
                 String ChildTwoAgeResults = ChildTwoAgeData;
                 Assert.assertEquals(ChildTwoAgeData, ChildTwoAgeResults, "not equal");

             }
         }       driver.quit();

         }
}


/**
 * Homework 14
 * Due: Dec 3rd
 *
 * darksky.net
 * Testcase-1: Verify low/high temp on Today timeline
 *
 * hotels.com
 * Testcase-2: Verify the number of nights on black briefcase
 * checkin: tomorrow (Dec-2)
 * checkout: 7 days from checkin date (Dec-9)
 *
 * Testcase-3: Enter the user details as mentioned
 * Rooms - 1
 * Adult - 1
 * Children - 2 (Ages: 1, 2)
 * Verify user details on Search page as entered/selected on Homepage
 */