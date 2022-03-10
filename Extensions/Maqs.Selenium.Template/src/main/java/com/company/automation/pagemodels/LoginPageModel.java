package com.company.automation.pagemodels;

import com.magenic.jmaqs.selenium.BaseSeleniumPageModel;
import com.magenic.jmaqs.selenium.LazyWebElement;
import com.magenic.jmaqs.selenium.SeleniumConfig;
import com.magenic.jmaqs.selenium.SeleniumTestObject;
import com.magenic.jmaqs.selenium.factories.UIWaitFactory;
import com.magenic.jmaqs.utilities.helper.exceptions.ExecutionFailedException;
import com.magenic.jmaqs.utilities.helper.exceptions.TimeoutException;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * The type Login page model.
 */
public class LoginPageModel extends BaseSeleniumPageModel {

  /**
   * The URL for the page.
   */
  private static final String PAGE_URL = SeleniumConfig.getWebSiteBase() + "/Static/Training1/loginpage.html";

  /**
   * Username Field Selector.
   */
  private static final By USERNAME_INPUT = By.cssSelector("#UserName");
  private LazyWebElement usernameInput = getLazyElement( USERNAME_INPUT,
      "Username Text Field");

  /**
   * Password Field Selector.
   */
  private static final By PASSWORD_INPUT = By.cssSelector("#Password");
  private LazyWebElement passwordInput = getLazyElement(PASSWORD_INPUT,
      "Password Text Field");

  /**
   * Login Error Message Selector.
   */
  private static final By LOGIN_ERROR = By.cssSelector("#LoginError");
  private LazyWebElement loginErrorMessage = getLazyElement(LOGIN_ERROR,
      "Login Error Message");

  /**
   * Login Button Selector.
   */
  private static final By LOGIN_BUTTON = By.cssSelector("#Login");
  private LazyWebElement loginButton = getLazyElement(LOGIN_BUTTON, "Login Button");

  /**
   * Login Page Model Constructor.
   *
   * @param testObject The WebDriver object to use
   */
  public LoginPageModel(SeleniumTestObject testObject) {
    super(testObject);
  }

  /**
   * Open the login page.
   */
  public void openLoginPage() {
    getWebDriver().navigate().to(PAGE_URL);
    Assert.assertTrue(this.isPageLoaded(), String.format("The web page %s is not loaded", PAGE_URL));
  }

  /**
   * Login with valid credentials.
   *
   * @param userName the user name
   * @param password the password
   * @return the home page model
   */
  public HomePageModel loginWithValidCredentials(String userName, String password)
      throws InterruptedException, TimeoutException, ExecutionFailedException {
    this.enterCredentials(userName, password);
    UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(LOGIN_BUTTON).click();

    return new HomePageModel(this.getTestObject());
  }

  /**
   * Login with invalid credentials.
   *
   * @param userName the user name
   * @param password the password
   * @return the boolean
   */
  public boolean loginWithInvalidCredentials(String userName, String password)
      throws InterruptedException, TimeoutException, ExecutionFailedException {
    this.enterCredentials(userName, password);
    UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(LOGIN_BUTTON).click();
    return UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(LOGIN_ERROR).isDisplayed();
  }

  /**
   * Enter credentials.
   *
   * @param userName the user name
   * @param password the password
   */
  public void enterCredentials(String userName, String password)
      throws InterruptedException, TimeoutException, ExecutionFailedException {
    usernameInput.sendKeys(userName);
    UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(PASSWORD_INPUT).sendKeys(password);
  }

  public boolean isPageLoaded() {
    try {
      return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    } catch (TimeoutException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return false;
  }
}
