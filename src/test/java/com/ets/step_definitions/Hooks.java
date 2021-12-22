package com.ets.step_definitions;

import com.ets.utilities.*;


import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class Hooks {


    MethodsUtil methodsUtil=new MethodsUtil();
    public WebDriver driver= Driver.getDriver();

    @Before
    public void setUp() {
        // we put a logic that should apply to every scenario
        //Driver.getDriver().manage().deleteAllCookies();

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"", "image/png");
        }
//       Driver.closeDriver();
    }


}
