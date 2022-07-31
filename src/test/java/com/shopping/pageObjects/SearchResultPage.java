package com.shopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    WebDriver ldriver;
    public SearchResultPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(linkText = "Apple MacBook Air 13 (2020)- 13,3 Zoll (2.560 x 1.600) IPS, Apple M1 Prozessor, 8GB RAM, 256GB SSD, Apple 7 Core GPU, macOS (Space Grau) MGN63D/A")
    WebElement lnkOpenProduct;

    public void openProduct(){
        lnkOpenProduct.click();
    }
}
