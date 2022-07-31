package com.shopping.testCases;

import com.shopping.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;

public class TC_Login_001 extends BaseClass {
    @Test
    public void loginTest() throws IOException, InterruptedException {

        logger.info("URL is opened");

        LoginPage lp=new LoginPage(driver);

       //Thread.sleep(10000);
        lp.loginHover();

        lp.setEmail(username);
        logger.info("Entered username");

        lp.clickWeiter();

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickLogin();
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='c24-customer-icon c24-customer-icon-lo c24-header-hover']")));
       Thread.sleep(3000);

        if(driver.getPageSource().contains("Navya Nagabhushana"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }


    }
}
