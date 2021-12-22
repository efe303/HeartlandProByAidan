package com.ets.step_definitions;

import com.ets.utilities.*;

import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class yourLagaMainPage {

    public WebDriver driver= Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(driver, 15);


    @Given("User is in MyStore login page")
    public void userIsInMyStoreLoginPage() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("urlQaYourLaga"));
    }


}
