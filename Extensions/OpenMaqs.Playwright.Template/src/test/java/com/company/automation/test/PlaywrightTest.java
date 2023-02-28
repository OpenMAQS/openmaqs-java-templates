package com.company.automation.test;

import com.company.automation.pagemodels.HomePageModel;
import com.company.automation.pagemodels.LoginPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * PlaywrightTest test class for TestNG.
 */
public class PlaywrightTest implements BasePlaywrightTest {

    /**
     * Open page test.
     */
    @Test
    public void openLoginPageTest() {
        LoginPageModel page = new LoginPageModel(this.getTestObject());
        page.openLoginPage();
    }

    /**
     * Enter credentials test.
     */
    @Test
    public void enterValidCredentialsTest() {
        String username = "Ted";
        String password = "123";
        LoginPageModel page = new LoginPageModel(this.getTestObject());
        page.openLoginPage();
        HomePageModel homepage = page.loginWithValidCredentials(username, password);
        Assert.assertTrue(homepage.isPageLoaded());
    }

    /**
     * Enter credentials test.
     */
    @Test
    public void enterInvalidCredentials() {
        String username = "NOT";
        String password = "Valid";
        LoginPageModel page = new LoginPageModel(this.getTestObject());
        page.openLoginPage();
        Assert.assertTrue(page.loginWithInvalidCredentials(username, password));
    }
}