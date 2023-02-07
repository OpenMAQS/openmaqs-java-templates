package com.company.automation.pagemodels;

import io.github.openmaqs.selenium.BaseSeleniumPageModel;
import io.github.openmaqs.selenium.ISeleniumTestObject;
import io.github.openmaqs.selenium.SeleniumConfig;
import io.github.openmaqs.selenium.factories.UIWaitFactory;
import org.openqa.selenium.By;

/**
 * The type Home page model.
 */
public class HomePageModel extends BaseSeleniumPageModel {

  /**
   * The URL for the page.
   */
  private static final String PAGE_URL = SeleniumConfig.getWebSiteBase() + "Static/Training3/HomePage.html";

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
   * Check if home page has been loaded
   *
   * @return True if the page was loaded
   */
  public boolean isPageLoaded() {
    return UIWaitFactory.getWaitDriver(getWebDriver()).waitForVisibleElement(WELCOME_MESSAGE).isDisplayed();
  }
}
