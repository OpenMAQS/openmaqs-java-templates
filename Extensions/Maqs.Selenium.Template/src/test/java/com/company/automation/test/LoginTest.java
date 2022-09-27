package com.company.automation.test;

import com.cognizantsoftvision.maqs.selenium.BaseSeleniumTest;
import com.cognizantsoftvision.maqs.utilities.helper.exceptions.ExecutionFailedException;
import com.cognizantsoftvision.maqs.utilities.helper.exceptions.TimeoutException;
import com.company.automation.pagemodels.HomePageModel;
import com.company.automation.pagemodels.LoginPageModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseSeleniumTest {

  private LoginPageModel setUp() {
    LoginPageModel page = new LoginPageModel(this.getTestObject());
    page.openLoginPage();
    return page;
  }

  @Test
  public void openHomePageTest() {
    LoginPageModel page = setUp();
    Assert.assertTrue(page.isPageLoaded());
  }

  @Test
  public void enterValidCredentialsTest() throws InterruptedException, TimeoutException, ExecutionFailedException {
    String username = "Ted";
    String password = "123";
    LoginPageModel page = setUp();
    HomePageModel homepage = page.loginWithValidCredentials(username, password);
    Assert.assertTrue(homepage.isPageLoaded());
    homepage.checkURL();
  }

  @Test
  public void enterInvalidCredentials() throws InterruptedException, TimeoutException, ExecutionFailedException {
    String username = "NOT";
    String password = "Valid";
    LoginPageModel page = setUp();
    Assert.assertTrue(page.loginWithInvalidCredentials(username, password));
  }
}