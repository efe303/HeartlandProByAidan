package com.ets.pages;

import com.ets.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {

    public mainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "search_query_top")
    public WebElement MainPageSearchBox;

    @FindBy(name = "submit_search")
    public WebElement MainPageSearchButton;
































































}
