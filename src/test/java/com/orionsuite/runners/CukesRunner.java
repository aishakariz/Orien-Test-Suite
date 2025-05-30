package com.orionsuite.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = "html:target/cucumber-reports.html",
        features = "src/test/resources",
        glue = "com/cydeo/step_definitions",
        dryRun = true,
        tags = "@wip",
        publish = true


)



public class CukesRunner {






}
