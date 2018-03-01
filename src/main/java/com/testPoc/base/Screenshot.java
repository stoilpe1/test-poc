package com.testPoc.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class Screenshot {

    public static void getScreenshot(ITestContext ctx, WebDriver driver) {
        String testName = ctx.getCurrentXmlTest().getName();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            int maxLength = 13;
            String uniqueId = RandomIdGenerator.getRandomId(maxLength);
            System.out.println("uniqueId for the screenshot is: " + uniqueId); // delete
            System.out.println("test screenshot for " + testName + " test is: " + uniqueId + "_test_screenshot.png"); // delete
            FileUtils.copyFile(file, new File("test-output/screenshots/" + uniqueId + "_" + testName + "_test_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
