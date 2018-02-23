package com.testPoc.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    // Note that there are platform dependent lines of code in the following method
    // Also make sure you update the src/main/resources folder with the correct
    // webdriver executables as per the operating system
    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver;
        String systemOs = null;
        systemOs = System.getProperty("os.name").toLowerCase();
        log.info("Operating System is: " + systemOs);
        log.info("Starting " + browser + " driver");
        ChromeOptions chromeOptions;
        switch(browser) {
        case "firefox":
            if(systemOs.contains("windows") && systemOs != null) {
                // include Windows specific webdriver instructions
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            } else if (systemOs.contains("mac") && systemOs != null) {
                // include MacOS specific webdriver instructions
                System.setProperty("webdriver.gecko.driver", "src/main/resources/");
            } else if (systemOs.contains("linux") && systemOs != null) {
                // include Linux specific webdriver instructions
                System.setProperty("webdriver.gecko.driver", "src/main/resources/"); 
            }
            driver = new FirefoxDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;
        case "chrome":
            if(systemOs.contains("windows") && systemOs != null) {
                // include Windows specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            } else if (systemOs.contains("mac") && systemOs != null) {
                // include MacOS specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/");
            } else if (systemOs.contains("linux") && systemOs != null) {
                // include Linux specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/");
            }            
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;
            /* these are planned for the future
            case "edge":
            System.setProperty("webdriver.edge.driver", "src/main/resources/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;          
        case "ie":
            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;   
        case "html":
            driver = new HtmlUnitDriver();
            break;
        case "phantom":
            System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
            driver = new PhantomJSDriver();
            break;*/
        default:
            // default currently uses Chrome
            if(systemOs.contains("windows") && systemOs != null) {
                // include Windows specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            } else if (systemOs.contains("mac") && systemOs != null) {
                // include MacOS specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/");
            } else if (systemOs.contains("linux") && systemOs != null) {
                // include Linux specific webdriver instructions
                System.setProperty("webdriver.chrome.driver", "src/main/resources/");
            }            
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;
        }
        return driver;
    }

}

/*

backup:

package com.testPoc.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;   

public class BrowserFactory {

    public static WebDriver getDriver(String browser, Logger log) {
        WebDriver driver;
        log.info("Starting " + browser + " driver");
        ChromeOptions chromeOptions;
        switch(browser) {
        case "firefox": 
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;
        case "chrome":
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;
        case "edge":
            System.setProperty("webdriver.edge.driver", "src/main/resources/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;          
        case "ie":
            System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize(); // remove if not needed
            break;   
        case "html":
            driver = new HtmlUnitDriver();
            break;
        case "phantom":
            System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
            driver = new PhantomJSDriver();
            break;
        default:
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            break;
        }
        return driver;
    }

}

 */

