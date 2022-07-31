package com.shopping.testCases;

import com.shopping.pageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_SearchProduct_002 extends BaseClass{

    @Test
    public void searchNewProduct() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.loginHover();

        lp.setEmail(username);
        logger.info("Entered username");

        lp.clickWeiter();

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickLogin();

        Thread.sleep(3000);

        SearchProductPage searchProduct=new SearchProductPage(driver);
        searchProduct.enterProductName("Mac Book Air");

        SearchResultPage searchResult = new SearchResultPage(driver);
        searchResult.openProduct();

        ProductDetailsPage productDetail = new ProductDetailsPage(driver);
        productDetail.clickZumKauf();



        CheckOutPage checkOut = new CheckOutPage(driver);

        checkOut.acceptJaBtn();



        //Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Mac Book Air");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"searchNewProduct");
            Assert.assertTrue(false);
        }


    }
}
