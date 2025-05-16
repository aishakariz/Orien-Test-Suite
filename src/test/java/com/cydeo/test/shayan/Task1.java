package com.cydeo.test.shayan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {


        //  Testing Site: https://login1.nextbasecrm.com/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login1.nextbasecrm.com/");
        //  Open Chrome browser and navigate to https://login1.nextbasecrm.com/
        //  Locate the username input box and enter a valid username (e.g., helpdesk1@cybertekschool.com)
        WebElement username =driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cydeo.com");
        //   Locate the password input box and enter a valid password (e.g., UserUser)
        WebElement password =driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        //   Click the Login button
        WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
        button.click();
        //   Verify that the current URL contains 'stream' after successful login
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains("stream")){
            System.out.println("URL verified.");
        }else {
            System.out.println("URL not verified.");
        }
        //   Verify that the 'Remember me' label is displayed
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement rememberMe = driver.findElement(By.xpath("//label[@for='USER_REMEMBER']"));
        if(rememberMe.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        //   Locate and verify the 'Forgot your password?' link using CSS Selector
        WebElement forgotPassword = driver.findElement(By.cssSelector("a.login-link-forgot-pass"));
        if(forgotPassword.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        //   Locate and verify the same link using XPath
        WebElement forgotXpath = driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']"));
        if(forgotXpath.isDisplayed()){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        //   Verify that the password input has attribute type='password'
        //System.out.println("password.getAttribute(\"type\") = " + password.getDomAttribute("type"));


        //   Perform a negative login test with incorrect username and check the error message
        //   Perform a negative login test with incorrect password and check the error message
        //   Use getText() to print the label of 'Remember me'
        //   Use getAttribute() to print the 'placeholder' value from the username field
        //  Use isDisplayed() to verify if the login button is visible
        //  Print the page title using getTitle() method and assert it contains 'Authorization'
    }
}