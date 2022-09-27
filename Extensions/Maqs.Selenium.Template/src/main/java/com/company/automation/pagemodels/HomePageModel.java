package com.company.automation.pagemodels;

import com.cognizantsoftvision.maqs.selenium.BaseSeleniumPageModel;
import com.cognizantsoftvision.maqs.selenium.ISeleniumTestObject;
import com.cognizantsoftvision.maqs.selenium.SeleniumConfig;
import com.cognizantsoftvision.maqs.selenium.factories.UIWaitFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * The type Home page model.
 */
public class HomePageModel extends BaseSeleniumPageModel {

  /**
   * The URL for the page.
   */
  private static final String PAGE_URL = SeleniumConfig.getWebSiteBase() + "/Static/Training1/HomePage.html";

  /**
   * Welcome Message Selector.
   */
  private static final By WELCOME_MESSAGE = By.cssSelector("#WelcomeMessage");

  /**
   * Instantiates a new Home page model.
   *
   * @param testObject the test object
   */
  public HomePageModel(ISeleniumTestObject testObject) {
    super(testObject);
  }

  /**
   * Open the login page.
   */
  public void checkURL(String url) {
    Assert.assertEquals(PAGE_URL, url, String.format("The URL: %s does not match", PAGE_URL));
  }

  /**
   * Check if home page has been loaded
   *
   * @return True if the page was loaded
   */
  public boolean isPageLoaded() {
    return UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(WELCOME_MESSAGE).isDisplayed();
  }
}
