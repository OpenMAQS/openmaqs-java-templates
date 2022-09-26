package com.company.automation.pagemodels;

import com.cognizantsoftvision.maqs.playwright.BasePlaywrightPageModel;
import com.cognizantsoftvision.maqs.playwright.IPlaywrightTestObject;
import com.cognizantsoftvision.maqs.playwright.PlaywrightSyncElement;

/**
 * The type Home page model.
 */
public class HomePageModel extends BasePlaywrightPageModel {

  /**
   * Instantiates a new Home page model.
   *
   * @param testObject the test object
   */
  public HomePageModel(IPlaywrightTestObject testObject) {
    super(testObject);
  }

  /**
   * Gets welcome message.
   * @return the welcome message element
   */
  private PlaywrightSyncElement welcomeMessage() {
    return new PlaywrightSyncElement(this.getPageDriver(), "#WelcomeMessage");
  }

  /**
   * Check if home page has been loaded
   *
   * @return True if the page was loaded
   */
  @Override
  public boolean isPageLoaded() {
    return this.welcomeMessage().isEventuallyVisible();
  }
}
