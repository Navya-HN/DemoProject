package com.shopping.testCases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.shopping.utilities.ReadConfig;

public class BaseClass {
    ReadConfig readconfig=new ReadConfig();

    public String baseURL=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) throws InterruptedException {
        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            driver=new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseURL);
        //driver.switchTo().frame("gdpr-consent-notice");
        //By cookies_accept = By.cssSelector("button[id='save'] span[class='mat-button-wrapper'] span");
        By cookies_accept = By.xpath("//a[@class='c24-cookie-consent-button' and contains(text(),'Akzeptieren')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();

    }

    @AfterClass
    public void tearDown()
    {

       // driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomestring()
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
}
