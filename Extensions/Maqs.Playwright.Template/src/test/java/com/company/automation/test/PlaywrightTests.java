package com.company.automation.test;

import com.cognizantsoftvision.maqs.playwright.BasePlaywrightTest;
import com.company.automation.pagemodels.HomePageModel;
import com.company.automation.pagemodels.LoginPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Playwright tests.
 */
public class PlaywrightTests extends BasePlaywrightTest {

  /**
   * Navigates to the Login page.
   * @return the Login Page model
   */
  public LoginPageModel setUp() {
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.openLoginPage();
    return page;
  }

  /**
   * Open login page test.
   */
  @Test
  public void openLoginPageTest() {
    LoginPageModel page = setUp();
    Assert.assertTrue(page.isPageLoaded());
  }

  /**
   * Enter credentials test.
   */
  @Test
  public void enterValidCredentialsTest() {
    String username = "Ted";
    String password = "123";
    LoginPageModel page = setUp();
    HomePageModel homepage = page.loginWithValidCredentials(username, password);
    Assert.assertTrue(homepage.isPageLoaded());
    Assert.assertTrue(homepage.checkURL());
  }

  /**
   * Enter credentials test.
   */
  @Test
  public void enterInvalidCredentials() {
    String username = "NOT";
    String password = "Valid";
    LoginPageModel page = setUp();
    Assert.assertTrue(page.loginWithInvalidCredentials(username, password));
  }
}
