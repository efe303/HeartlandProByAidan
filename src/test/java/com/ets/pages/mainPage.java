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

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")
    public WebElement selectFirstImage;

    @FindBy(className = "icon-plus")
    public WebElement SelectQuantity;

    @FindBy(id = "group_1")
    public WebElement selectSize;

    @FindBy(id = "color_8")
    public WebElement selectColor;

    @FindBy(id = "add_to_cart")
    public WebElement addToCart;

    @FindBy(css = "div.layer_cart_product.col-xs-12.col-md-6 > h2")
    public WebElement itemVisibleInTheCart;































































}
