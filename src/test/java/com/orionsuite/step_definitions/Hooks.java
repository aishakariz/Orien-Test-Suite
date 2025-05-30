package com.orionsuite.step_definitions;

import com.orionsuite.utilities.Driver;
import com.orionsuite.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "pre" and "post" condition
for ALL the SCENARIOS and STEPS.

 */
public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before
    public void setupMethod() {
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @Before (value = "@login", order = 2 )
    public void login_scenario_before(){
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    /*
    After will be executed automatically after EVERY scenario in the project.
     */

    @After
    public void teardownMethod(Scenario scenario) {

        byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());


        System.out.println("---> AFTER: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("------->@BeforeStep: Running before each steps!");
    }


  // @AfterStep
    public void teardownStep(){
        System.out.println("------->@AfterStep: Running after each steps!");
    }



}
