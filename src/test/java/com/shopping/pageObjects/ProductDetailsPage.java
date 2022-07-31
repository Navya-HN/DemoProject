package com.shopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    WebDriver ldriver;

    public ProductDetailsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//button[contains(@data-gtm-value,'MacTrade GmbH')]//span[contains(text(),'zum Kauf')]")
    WebElement btnZumKauf;

    public void clickZumKauf(){
        btnZumKauf.click();
    }
}
