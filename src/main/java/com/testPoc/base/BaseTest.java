package com.testPoc.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    // only classes that EXTEND this class will be able to use the protected methods
    // and variables
    protected WebDriver driver;
    protected Logger log;
    // make screenshotAlwaysOn = true if you want to debug
    // headless or just take screenshots on every driver quit
    // default value is false
    protected Boolean screenshotAlwaysOn = false;
    
    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx) {
        // this way when we start the test it's gonna create the log with the test name
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }
    
    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    protected void methodSetUp(String browser) {
        // ChromeDriver setup:
        log.info("Method Set Up");
        
        // call method to get browser based on parameter
        driver = BrowserFactory.getDriver(browser, log);        
    }

    @SuppressWarnings("static-access")
    @AfterMethod(alwaysRun = true)
    protected void methodTearDown(ITestContext ctx, ITestResult tr) {
        // take a screenshot either if test fails
        // or if screenshotAlwaysOn is TRUE
        if(tr.FAILURE==tr.getStatus() || screenshotAlwaysOn==true) {
            Screenshot.getScreenshot(ctx, driver);
        }        
        
        // Quit driver
        log.info("Method Tear Down");
        driver.quit();
    }
}