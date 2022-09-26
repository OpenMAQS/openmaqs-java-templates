package com.company.automation.test.stepdefs.appium;

import com.cognizantsoftvision.maqs.appium.AppiumTestObject;
import com.cognizantsoftvision.maqs.appium.BaseAppiumTest;
import com.cognizantsoftvision.maqs.cucumber.ScenarioContext;
import com.cognizantsoftvision.maqs.cucumber.steps.BaseGenericStep;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BaseAppiumStep extends BaseGenericStep {

  /**
   * Get the web driver.
   *
   * @return The web driver
   */
  public AppiumDriver<WebElement> getDriver() {
    return getTestObject().getAppiumDriver();
  }

  @Override
  public AppiumTestObject getTestObject() {
    return ScenarioContext.get(
        ScenarioContext.MAQS_HOLDER, BaseAppiumTest.class).getTestObject();
  }
}
