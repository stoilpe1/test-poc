package com.testPoc;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import com.testPoc.base.BaseTest;
import com.testPoc.base.CsvDataProvider;

public class LoginTest extends BaseTest {
    
    @Test(priority = 1, groups = { "positive" })
    public void positiveLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver, log);
        String expectedPageTitle = "Create Profile";
        String expectedCreateYourProfileMessage = "Create your profile, find your next position.";
        
        // Go to DICE url
        loginPage.openLoginPage();

        // Set login information (username + password)
        loginPage.fillUpEmailAndPassword("tpoctest@yahoo.com", "KLjgyjsdgyuwqehSAUIhiudh27868uiuhJKH@28288+____asd");

        // Click Sign In button and wait for Profile page to load
        ProfilePage profilePage = loginPage.clickSignInButton();
        profilePage.waitForProfilePageToLoad();

        // Verifications
        // - title of the page = Seeker Dashboard - Profile
        log.info("Executing verifications");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),
                "Page title is not correct.\nExpected: " + expectedPageTitle + "\nActual: " + actualTitle + ".");
                // if expected and actual page titles are not the same, TestNG will throw the error message and also
                // print expected and actual titles
        
        // - verify correct message displays =
        // h1.form-title text = "Create your profile, find your next position."
        Assert.assertTrue(profilePage.isCorrectMessageDisplayed(expectedCreateYourProfileMessage), "Create your profile message is not correct.");
    }
    
    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2, groups = { "negative", "broken" })
    public void negativeLoginTest(Map<String, String> testData) throws Exception {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");
        
        log.info("Test No #" + testNumber + " for " + description + "\nWhere:\nEmail: " + email + "\nPassword: " + password);
        
        LoginPage loginPage = new LoginPage(driver, log);
        
        // Go to DICE url
        loginPage.openLoginPage();
        
        // Set login information (username + password)
        loginPage.fillUpEmailAndPassword(email, password);
        
        // Click Sign In button
        loginPage.clickSignInButton();
        
        String errorMessageActual = loginPage.getLoginErrorMessage();
        Assert.assertTrue(errorMessageActual.contains(expectedErrorMessage),
                "Error message is not correct.\nExpected: " + expectedErrorMessage + "\nActual: " + errorMessageActual + ".");
        
    }

}
