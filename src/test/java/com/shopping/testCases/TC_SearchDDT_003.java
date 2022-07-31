package com.shopping.testCases;

import java.io.IOException;
import java.util.List;

import com.shopping.pageObjects.SearchProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopping.pageObjects.LoginPage;
import com.shopping.utilities.XLUtils;


public class TC_SearchDDT_003 extends BaseClass{
    @Test(dataProvider="SearchData")
    public void searchProduct(String productName) throws InterruptedException
    {
        SearchProductPage sp =new SearchProductPage(driver);
        sp.enterProductName(productName);

        String res=driver.findElement(By.xpath("//span[@class='result-message__orange']")).getText();
        System.out.println(res);

        List<WebElement> listResult= driver.findElements(By.xpath("(//div[@class='result-item-tile result-item-tile--desktop result-item-tile--product'])"));
        int listSize = listResult.size();
        for(int i=1; i<=listSize;i++)
        {
           String s= driver.findElement(By.xpath("(//div[@class='result-item-tile result-item-tile--desktop result-item-tile--product'])"+"["+i+"]")).getText();
        System.out.println(s);
        }
    }


    @DataProvider(name="SearchData")
    String [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/shopping/testData/SearchData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
