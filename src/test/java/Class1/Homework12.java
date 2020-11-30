package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class Homework12 {

    /**
     *
     * Homework - 12
     * Due Date: Nov 23, 2020 (Monday)
     *
     *
     * Testcase 1: Verify the feels-like temp value is between low and high temp values at any zipcode
     *
     *
     *
     * Testcase 2: Verify the dates on the Blog Page page appears in reverse chronological order
     *
     *
     *
     * Testcase 3: Verify the temperature value converts as expected as the the unit selected
     *
     *
     *
     */

// This Homework isn't for checking yet, still incomplete or wasn't successful.

    @Test
    public void verifyFeelsLike () {

        //Test Case Steps:
        // 1. Launch darksky.net
        // 2. generate locators for feels like, low temp, and high temp
        // 3. compare the value of feelsLike using locators
        // 4. compare the value of feelsLike with lowTemp, with the expected result as not equal
        // 5. compare the value of feelsLike with highTemp, with the expected result as not equal

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");

        WebElement feelsLikeLocator = driver.findElement(By.xpath("//span[@class='feels-like-text']"));

        WebElement lowTempLocator = driver.findElement(By.xpath("//span[@class='low-temp-text']"));

        WebElement highTempLocator = driver.findElement(By.xpath("//span[@class='high-temp-text']"));

        Assert.assertNotEquals("feelsLikeLocator", "lowTempLocator");

        Assert.assertNotEquals("feelsLikeLocator", "highTempLocator");





        }


        // Test Case 2 Steps:
        //
         @Test
         public void verifyDates () {

             System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

             WebDriver driver = new ChromeDriver();

             driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");

             WebElement MarchLocator = driver.findElement(By.xpath("//time[contains(text(), 'March 31, 2020')]"));
             WebElement JulyLocator = driver.findElement(By.xpath("//time[contains(text(), 'July 1, 2020')]"));
             WebElement AugustLocator = driver.findElement(By.xpath("//time[contains(text(), 'August 1, 2020')]"));

             SimpleDateFormat sdf = new SimpleDateFormat("MMM-YYYY");






         }

         @Test
         public void verifyTempConvert () {

             System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

             WebDriver driver = new ChromeDriver();

             driver.get("https://darksky.net/forecast/40.7127,-74.0059/us12/en");



         }





      // wasn't successful with this Homework, don't check.









    }





















