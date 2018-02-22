package com.dice.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testPoc.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.cssSelector("button.btn-primary.btn-block"); // "//button[@type='submit']"
    private By errorMessageElement = By.xpath("//span[@data-automation-id='login-failure-help-message']");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log); // when we create LoginPage we are going to get driver
                       // from test and this driver will go directly
                       // to BasePageObject
    }

    public void openLoginPage() {
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        log.info("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage clickSignInButton() throws Exception { // this returns a new ProfilePage
        log.info("Clicking on Sign In button");
        find(signInButton).click();
        return new ProfilePage(driver, log);

    }

    public String getLoginErrorMessage() {
        waitForVisibilityOf(errorMessageElement, 10);
        return getText(errorMessageElement);
    }

}
