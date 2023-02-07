package com.company.automation.test;

import io.github.openmaqs.appium.AppiumConfig;
import io.github.openmaqs.appium.BaseAppiumTest;
import io.github.pagemodels.LoginPageModel;
import io.github.pagemodels.MainPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Appium tests.
 */
public class AppiumTest extends BaseAppiumTest {

  /**
   * Application installed test.
   */
  @Test
  public void applicationInstalledTest() {
    Assert.assertTrue(this.getAppiumDriver().isAppInstalled(AppiumConfig.getBundleId()),
        "Expected application to be installed");
  }

  /**
   * Invalid login test.
   */
  @Test
  public void invalidLoginTest() {
    String expectedError = "Wrong username or password";
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.loginWithInvalidCredentials("Not", "Valid");
    String errorMessage = page.getErrorMessage();
    Assert.assertEquals(errorMessage, expectedError, "Expected error message to be equal");
  }

  /**
   * Valid login test.
   */
  @Test
  public void validLoginTest() {
    String username = "Magenic";
    String password = "MAQS";
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    MainPageModel mainPageModel = page.loginWithValidCredentials(username, password);
    String loggedInPassword = mainPageModel.getPasswordValueText();
    String loggedInUsername = mainPageModel.getUsernameValueText();

    Assert.assertEquals(loggedInUsername, username, "Expected username value to be equal");
    Assert.assertEquals(loggedInPassword, password, "Expected password value to be equal");
  }
}
