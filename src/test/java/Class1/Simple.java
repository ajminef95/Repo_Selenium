package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Simple {

    @Test
    public void verifyMaleButton() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        WebElement CreateAccLoc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));

        CreateAccLoc.click();

       WebElement maleButtonLoc =  driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input"));

       Assert.assertFalse(maleButtonLoc.isSelected());

       if (!maleButtonLoc.isSelected()) {

           maleButtonLoc.click();
       }

        Assert.assertTrue(maleButtonLoc.isSelected());

    }

    /**
     * To verify if webElement is Selected or not
     * Method: isSelected()
     * Return type: boolean
     */
    /**
     * Test Scenario: Verify gender is not selected
     * 1. Launch facebook.com
     * 2. Click on 'Create New Account'
     * 3. Verify Male radio button is not selected
     * 4. Select Male-radio button ONLY if it not selected
     * 5. Verify Male radio button is selected
     */









}
