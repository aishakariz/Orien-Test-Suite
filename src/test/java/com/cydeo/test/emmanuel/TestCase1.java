package com.cydeo.test.emmanuel;

import com.cydeo.Utilities.BrowserUtils;
import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 {
    // Tasks for Week 1 – Practice Assignments (Total: 15)
    //🧪 Testing Site: https://login1.nextbasecrm.com/
    //Open Chrome browser and navigate to https://login1.nextbasecrm.com/
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void test1(){
        //Locate the username input box and enter a valid username (e.g., helpdesk1@cydeo.com)
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys("helpdesk1@cydeo.com");

        //Locate the password input box and enter a valid password (e.g., UserUser)

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        //Click the Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
        BrowserUtils.sleep(3);

        //Verify that the current URL contains 'stream' after successful login
        String expected = "stream";
        String actualURL = driver.getCurrentUrl();

        assert actualURL != null;
        Assert.assertTrue(actualURL.contains(expected));
        BrowserUtils.sleep(4);

        //Verify that the 'Remember me' label is displayed
        driver.navigate().back();
        BrowserUtils.sleep(4);


        WebElement rememberMeText = driver.findElement(By.xpath("//label[@for='USER_REMEMBER']"));

        expected = "Remember me on this computer";
        String actual = rememberMeText.getText();
        Assert.assertEquals(actual, expected);

        //Locate and verify the 'Forgot your password?' link using CSS Selector

        WebElement forgotPassword = driver.findElement(By.cssSelector("a.login-link-forgot-pass"));
        expected = "FORGOT YOUR PASSWORD?";
        actual = forgotPassword.getText();

        Assert.assertEquals(actual, expected);

        //Locate and verify the same link using XPath
        WebElement forgotPasswordXpath = driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']"));
        String expectedPass = "FORGOT YOUR PASSWORD?";
        String actualPass = forgotPassword.getText();
        Assert.assertEquals(actualPass, expectedPass);




    }










    //Perform a negative login test with incorrect username and check the error message
    //Perform a negative login test with incorrect password and check the error message
    //Use getText() to print the label of 'Remember me'
    //Use getAttribute() to print the 'placeholder' value from the username field
    //Use isDisplayed() to verify if the login button is visible
    //Print the page title using getTitle() method and assert it contains 'Authorization'

}
