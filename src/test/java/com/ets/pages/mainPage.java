package com.ets.pages;

import com.ets.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {

    public mainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ctl00_HyperLink1")
    public WebElement MainPageHomeButton;

    @FindBy(css = "")
    public WebElement MainPageSearchBox;
































































}
