package com.ets.step_definitions;

import com.ets.pages.mainPage;
import com.ets.utilities.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class yourLagaMainPage {

    public WebDriver driver= Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(driver, 15);
    mainPage mainPageLocator=new mainPage();

    @Given("User is in MyStore login page")
    public void userIsInMyStoreLoginPage() {

    }

    @Given("User is in MyStore main page")
    public void user_is_in_my_store_main_page() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("urlQaYourLaga"));
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("http://automationpractice.com/index.php",driver.getCurrentUrl());
    }


    @Given("User search a product from the input box and clicks on search button")
    public void user_search_a_product_from_the_input_box_and_clicks_on_search_button() {

        mainPageLocator.MainPageSearchBox.sendKeys("Printed Chiffon Dress");
        mainPageLocator.MainPageSearchButton.click();
    }
    @Given("user selects a size and a color, add it to the chard")
    public void user_selects_a_size_and_a_color_add_it_to_the_chard() {

    }
    @Then("User should be able to see item is visible in the cart")
    public void user_should_be_able_to_see_item_is_visible_in_the_cart() {

    }


}
