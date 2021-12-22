package com.ets.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@smokeTest",
        features = "src/test/resources/com/features",
        glue = "com/ets/step_definitions",  //make sure the file path is as short as possible otherwise it does not recognize it
        monochrome = true,                        //it removes extra characters at the console
        dryRun = false,                        // when you want to run the file just to confirm all the cucumber steps have step definitions.
        plugin = {"json:target/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "html:target/report/cucumber.html",
                "pretty"
        } // for reports



)

public class CukesRunner {
}
