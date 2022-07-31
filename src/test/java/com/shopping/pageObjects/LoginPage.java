package com.shopping.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath="//span[@class='c24-customer-icon c24-customer-icon-lo c24-header-hover']")
    @CacheLookup
    WebElement MeinKonto;

    @FindBy(xpath="//a[@id='c24-meinkonto-anmelden']")
    @CacheLookup
    WebElement btnAnmelden;

    @FindBy(xpath = "//input[@id='cl_login']")
    WebElement txtEmail;

    @FindBy(xpath = "//button[@id='c24-uli-login-btn']")
    WebElement btnWeiter;

    @FindBy(xpath = "//input[@id='cl_pw_login']")
    WebElement txtPass;

    @FindBy(xpath="//button[@id='c24-uli-pw-btn']//span[contains(text(),'anmelden')]")
    WebElement btnSubmit;


    public void loginHover() throws InterruptedException {
        //Instantiating Actions class
        Actions actions = new Actions(ldriver);

        WebElement ele=ldriver.findElement(By.xpath("//span[@class='c24-customer-icon c24-customer-icon-lo c24-header-hover']"));
        //Hovering on main menu
        actions.moveToElement(ele).perform();

        Thread.sleep(10000);
        btnAnmelden.click();
        //To mouseover on sub menu
        //actions.moveToElement(btnAnmelden);

//build()- used to compile all the actions into a single step

    }


    public void setEmail(String uname) throws InterruptedException {
        //Thread.sleep(3000);
        int size = ldriver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        ldriver.switchTo().frame(0);
        txtEmail.click();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {
        txtPass.sendKeys(pwd);
    }


    public void clickWeiter()
    {
        btnWeiter.click();
    }

    public void clickLogin()
    {
        btnSubmit.click();
    }

}
