package com.company.automation.test;

import io.github.openmaqs.appium.BaseAppiumTest;
import io.github.openmaqs.base.BaseTest;
import io.github.openmaqs.cucumber.BaseCucumberTestNG;

public class BaseAppiumCucumber extends BaseCucumberTestNG {
  @Override
  public BaseTest createSpecificBaseTest() {
    return new BaseAppiumTest();
  }
}
