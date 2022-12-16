package com.company.automation.test.stepdefs.appium;

import io.github.maqs.appium.AppiumTestObject;
import io.github.maqs.appium.BaseAppiumTest;
import io.github.maqs.cucumber.ScenarioContext;
import io.github.maqs.cucumber.steps.BaseGenericStep;
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
