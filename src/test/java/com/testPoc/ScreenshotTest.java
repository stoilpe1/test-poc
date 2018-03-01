package com.testPoc;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.testPoc.base.RandomIdGenerator;

public class ScreenshotTest {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        //Set Chrome Headless mode as TRUE
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        
        //Instantiate Web Driver and open web page
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        System.out.println("Page title is - " + driver.getTitle());
        
        
        
        //Search on Google
        driver.findElement(By.name("q")).sendKeys("selenium webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        
        //Take screenshot
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            int maxLength = 13;
            String uniqueId = RandomIdGenerator.getRandomId(maxLength);
            System.out.println("uniqueId for the screenshot is: " + uniqueId); // delete
            System.out.println("test screenshot for this test is: " + uniqueId + "_headless_screenshot.png"); // delete
            FileUtils.copyFile(file, new File("test-output/screenshots/" + uniqueId + "_headless_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        driver.close();
    }

}
