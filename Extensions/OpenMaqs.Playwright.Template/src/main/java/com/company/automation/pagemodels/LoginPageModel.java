package com.company.automation.pagemodels;

import com.company.automation.pagemodels.HomePageModel;
import io.github.openmaqs.playwright;
import org.testng.Assert;

/**
 * Page object for the Automation page.
 */
public class LoginPageModel implements BasePlaywrightPageModel {

    /**
     * Initializes a new instance of the LoginPageModel class.
     * @param testObject The base Playwright test object
     */
    public LoginPageModel(IPlaywrightTestObject testObject) {
        super(testObject);
    }

    /**
     * Get page url.
     * @return the page url
     */
    public static String getUrl() {
        return PlaywrightConfig.WebBase() + "Static/Training3/LoginPage.html";
    }

    /**
     * Gets the username input box.
     * @return the username input box element
     */
    private PlaywrightSyncElement getUserNameInput() {
        return new PlaywrightSyncElement(this.getPageDriver(), "#name");
    }

    /**
     * Gets the password input box.
     * @return the password input box element
     */
    private PlaywrightSyncElement getPasswordInput() {
        return new PlaywrightSyncElement(this.getPageDriver(), "#pw");
    }

    /**
     * Gets the login button.
     * @return the login button element
     */
    private PlaywrightSyncElement getLoginButton() {
        return new PlaywrightSyncElement(this.getPageDriver(), "#Login");
    }

    /**
     * Gets the error message.
     * @return the login error message
     */
    private PlaywrightSyncElement getErrorMessage() {
        return new PlaywrightSyncElement(this.getPageDriver(), "#LoginError");
    }

    /**
     * Open the login page.
     */
    public void getOpenLoginPage() {
        this.getPageDriver().Goto(getUrl());
        this.assertPageLoaded();
    }

    /**
     * Enter the username and password credentials.
     * @param userName The username
     * @param password The user password
     */
    public void enterCredentials(String userName, String password) {
        this.getUserNameInput().type(userName);
        this.getPasswordInput().type(password);
    }

    /**
     * Enter the use credentials and log in - Navigation sample.
     * @param userName The username
     * @param password The user password
     * @return The home page model
     */
    public HomePageModel getLoginWithValidCredentials(String userName, String password) {
        this.enterCredentials(userName, password);
        this.getLoginButton().click();

        return new HomePageModel(this.getTestObject());
    }

    /**
     * Enter the use credentials and try to log in - Verify login failed.
     * @param userName The username
     * @param password The user password
     * @return True if the error message is displayed
     */
    public boolean loginWithInvalidCredentials(String userName, String password) {
        this.enterCredentials(userName, password);
        this.getLoginButton().click();
        return this.getErrorMessage().isEventualyVisible();
    }

    /**
     * Open the page.
     */
    public void openPage() {
        this.getPageDriver().navigateTo(getUrl());
    }

    /**
     * Assert the login page loaded.
     */
    public void assertPageLoaded() {
        Assert.assertTrue(this.isPageLoaded(), "The web page '" + getUrl() + "' is not loaded");
    }

    /**
     * Check if the home page has been loaded.
     * @return True if the page was loaded
     */
    @Override
    public boolean isPageLoaded() {
        return this.getUserNameInput().isEventualyVisible() && this.getPasswordInput().isEventualyVisible() && this.getLoginButton().isEventualyVisible();
    }
}