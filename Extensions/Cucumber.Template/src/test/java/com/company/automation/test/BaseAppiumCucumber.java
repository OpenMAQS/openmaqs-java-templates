package com.company.automation.test;

import io.github.maqs.appium.BaseAppiumTest;
import io.github.maqs.base.BaseTest;
import io.github.maqs.cucumber.BaseCucumberTestNG;

public class BaseAppiumCucumber extends BaseCucumberTestNG {
  @Override
  public BaseTest createSpecificBaseTest() {
    return new BaseAppiumTest();
  }
}
