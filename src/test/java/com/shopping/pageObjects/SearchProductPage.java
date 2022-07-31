package com.shopping.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

    WebDriver ldriver;
    public SearchProductPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath="//input[@id='c24-search-header']")
    WebElement txtSearchField;

    //@FindBy(xpath = "//*[contains(text(),'Nein')]")
    //WebElement radioBtnNein;



    public void enterProductName(String product) {
        txtSearchField.clear();
        txtSearchField.sendKeys(product);
        txtSearchField.sendKeys(Keys.ENTER);



    }










}
