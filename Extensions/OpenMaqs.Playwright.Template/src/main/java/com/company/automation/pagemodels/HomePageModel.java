package com.company.automation.pagemodels;

import io.github.openmaqs.playwright.BasePlaywrightPageModel;
import io.github.openmaqs.playwright.IPlaywrightTestObject;

/**
 * Playwright page model class for testing.
 */
public class HomePageModel implements BasePlaywrightPageModel {

    /**
     * Initializes a new instance of the HomePageModel class.
     * @param testObject returns an IPlaywright Test Object
     */
    protected HomePageModel(IPlaywrightTestObject testObject) {
            super(testObject);
        }

    /**
     * Gets welcome message.
     * @return the welcome message playwright element
     */
    private PlaywrightSyncElement welcomeMessage() {
        return new PlaywrightSyncElement(this.getPageDriver(), "#WelcomeMessage");
    }

    /**
     * Check if the home page has been loaded.
     * @return true if the page has been loaded
     */
    @Override
    public boolean isPageLoaded() {
        return this.welcomeMessage().isEventualyVisible();
        }
}
