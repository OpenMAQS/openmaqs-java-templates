package com.company.automation.pagemodels;

import com.cognizantsoftvision.maqs.playwright.BasePlaywrightPageModel;
import com.cognizantsoftvision.maqs.playwright.IPlaywrightTestObject;
import com.cognizantsoftvision.maqs.playwright.PlaywrightConfig;
import com.cognizantsoftvision.maqs.playwright.PlaywrightSyncElement;
import org.testng.Assert;

/**
 * The Login page model.
 */
public class LoginPageModel extends BasePlaywrightPageModel {

  /**
   * Initializes a new instance of the LoginPageModel class.
   * @param testObject The base Playwright test object
   */
  public LoginPageModel(IPlaywrightTestObject testObject) {
    super(testObject);
  }

  /**
   * Gets page url
   */
  public static final String URL = PlaywrightConfig.getWebBase() + "Training3/LoginPage.html";

  /**
   * Gets username box.
   * @return the username box playwright username box input
   */
  private PlaywrightSyncElement userNameInput() {
    return new PlaywrightSyncElement(this.getPageDriver(), "#name");
  }

  /**
   * Gets password box.
   * @return the password playwright element
   */
  private PlaywrightSyncElement passwordInput() {
    return new PlaywrightSyncElement(this.getPageDriver(), "#pw");
  }

  /**
   * Gets login button.
   * @return the login button playwright element
   */
  private PlaywrightSyncElement loginButton() {
    return new PlaywrightSyncElement(this.getPageDriver(), "#Login");
  }

  /**
   *  Gets error message
   * @return the error message playwright element
   */
  private PlaywrightSyncElement errorMessage() {
    return new PlaywrightSyncElement(this.getPageDriver(), "#LoginError");
  }

  /**
   * Open the login page.
   */
  public void openLoginPage() {
    this.getPageDriver().navigateTo(URL);
    this.assertPageLoaded();
  }

  /**
   * Enter the use credentials.
   * @param userName The username
   * @param password The user password
   */
  public void enterCredentials(String userName, String password) {
    this.userNameInput().type(userName);
    this.passwordInput().type(password);
  }

  /**
   * Enter the use credentials and log in - Navigation sample.
   * @param userName The username
   * @param password The user password
   * @return The home page
   */
  public HomePageModel loginWithValidCredentials(String userName, String password) {
    this.enterCredentials(userName, password);
    this.loginButton().click();
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
    this.loginButton().click();
    return this.errorMessage().isEventuallyVisible();
  }

  /**
   * Assert the login page loaded.
   */
  public void assertPageLoaded() {
    Assert.assertTrue(this.isPageLoaded(), "The web page '" + URL + "' is not loaded");
  }

  /**
   * Check if the home page has been loaded
   * @return True if the page was loaded
   */
  @Override
  public boolean isPageLoaded() {
    return this.userNameInput().isEventuallyVisible()
        && this.passwordInput().isEventuallyVisible()
        && this.loginButton().isEventuallyVisible();
  }
}
