package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework13 {

    @Test
    public void clickFirstNotification () {


        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");

        WebElement bellIconLoc = driver.findElement(By.xpath("//label[@for='ybarNotificationMenu']"));

        Actions act = new Actions(driver);

        act.moveToElement(bellIconLoc).build().perform();

        act.click(bellIconLoc);

       WebElement firstNotificationLoc = driver.findElement(By.xpath("//span[starts-with(text()='Top Story: Las Vegas')]"));

       act.click(firstNotificationLoc).build().perform();



    }

    @Test
     public void verifyInvalidDOB () {

         System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

         WebDriver driver = new ChromeDriver();

         driver.get("https://www.facebook.com/");

        WebElement CreateAccLoc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));

        CreateAccLoc.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }



        WebElement firstNameLoc = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstNameLoc.sendKeys("fName");

        WebElement lastNameLoc = driver.findElement(By.xpath("//input[@name='lastname']"));

        lastNameLoc.sendKeys("lName");

        WebElement emailAddressLoc = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']"));

        emailAddressLoc.sendKeys("abcd@test.com");

        WebElement reEnterEmailAddLoc = driver.findElement(By.xpath("//input[@aria-label='Re-enter email']"));

        reEnterEmailAddLoc.sendKeys("abcd@test.com");

        WebElement password = driver.findElement(By.id("password_step_input"));

        password.sendKeys("abcd@1234");

        WebElement monthElement = driver.findElement(By.id("month"));

        Select s1 = new Select(monthElement);

        s1.selectByVisibleText("Nov");

        WebElement dayElement = driver.findElement(By.id("day"));

        Select s2 = new Select(dayElement);

        s2.selectByVisibleText("4");

        WebElement yearElement = driver.findElement(By.id("year"));

        Select s3 = new Select(yearElement);

        s3.selectByVisibleText("1995");

        WebElement signUpLoc = driver.findElement(By.xpath("//button[@name='websubmit']"));

        signUpLoc.click();

        WebElement errorMessageGender = driver.findElement(By.xpath("//div[contains(text(), 'Please choose a gender')]"));

        boolean isErrorMessageDisplayed = errorMessageGender.isDisplayed();

        Assert.assertTrue(isErrorMessageDisplayed, "Gender Error Message is not displayed");








     }



}


/**
 *
 * Homework: 13
 * Due Date: Nov 28th, 2020
 *
 * Testcase-1: User should be able to click on the yahoo notification
 * 1. Launch yahoo.com
 * 2. Move mouse to bell icon
 * 3. user should be able to click the first notification
 *
 *
 * Testcase-2: User should get error on invalid date of birth
 * 1. Launch facebook.com
 * 2. Click 'Create new Account' button
 * 3. Enter fname as Firstname
 * 4. Enter lname as Lastname
 * 5. "abcd@test.com" as email address
 * 6. "abcd@1234" as New Password
 * 7. Enter your "Jan 4 1998" as birth date
 * 8. Click the 'Sign Up' button
 * 9. Verify user see the error msg for gender. (Please choose a gender. You can change who can see this later.)
 *
 */
