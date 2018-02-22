package com.testPoc.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    // only classes that EXTEND this class will be able to use the protected methods
    // and variables
    protected WebDriver driver;
    protected Logger log;
    
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

    @AfterMethod(alwaysRun = true)
    protected void methodTearDown() {
        // Quit driver
        log.info("Method Tear Down");
        driver.quit();
    }
}
