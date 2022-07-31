package com.shopping.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver ldriver;

    public CheckOutPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //@FindBy(xpath="//label[@data-tid='points-radio-agree']")
    @FindBy(xpath="//input[@id='c24-uli-points-true' and @type='radio']")
    WebElement radioBtnJa;

    public void acceptJaBtn(){
        //JavascriptExecutor executor = (JavascriptExecutor) ldriver;
        //executor.executeScript("arguments[0].click();",radioBtnJa);
        Actions build = new Actions(ldriver);
        build.moveToElement(radioBtnJa).contextClick().build().perform();
        //radioBtnJa.click();
    }
}

