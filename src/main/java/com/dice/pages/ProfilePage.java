package com.dice.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testPoc.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {
    
    //private By uploadResumeButton = By.cssSelector("input.upload:nth-child(2)");
                                    // note there are two buttons but second one is hidden
                                    // this will get first button (correct)
                                    // currently cannot be used for wait
    private By manuallyFillProfileButton = By.xpath("//*[@id='switch-view-wrapper']/a");
    private By createYourProfileMessage = By.cssSelector("h1.form-title"); // alt By.xpath("//h1[@class='form-title']")

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void waitForProfilePageToLoad() {
        log.info("Waiting for Profile Page to load");
        //waitForVisibilityOf(uploadResumeButton); // this does not work for some reason
        waitForVisibilityOf(manuallyFillProfileButton, 10);
    }

    /*public String getCreateYourProfileMessageText() {
        String createYourProfileMessageText = createYourProfileMessage.getText();
        return createYourProfileMessageText;
    }*/
    
    public boolean isCorrectMessageDisplayed(String correctCreatYourProfileMessageText) {
        if (getText(createYourProfileMessage).equals(correctCreatYourProfileMessageText)) {
            return true;
        }
        return false;
    }
}
