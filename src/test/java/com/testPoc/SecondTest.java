package com.testPoc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testPoc.base.BaseTest;

public class SecondTest extends BaseTest {

    @Test
    public void secondTestMethod() throws Exception {
        // Actual test steps here:
        // Open URL
        driver.get("https://mas-qual.novartis.net");
        log.info("MAS is opened");

        // Check if H1 contains "Novartis Telephony & Mobility Communities" welcome
        // message
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(500);
        String welcomeMessage = driver.findElement(By.cssSelector(".welcome-box-content h1")).getText();
        log.info("h1 string is= " + welcomeMessage);
        Assert.assertEquals(welcomeMessage, "Welcome to MAS Request Tool");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
