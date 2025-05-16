package com.cydeo.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){


        if(browserType.equalsIgnoreCase("chrome")){

            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();

        }else {
            System.out.println("Given string doesn't represent any browser.");
            System.out.println("Either that browser does not exist or not currently supported.");
            System.out.println("driver = null");
            return null;
        }
    }
}
