package com.company.automation.test;

import com.cognizantsoftvision.maqs.appium.BaseAppiumTest;
import com.cognizantsoftvision.maqs.base.BaseTest;
import com.cognizantsoftvision.maqs.cucumber.BaseCucumberTestNG;

public class BaseAppiumCucumber extends BaseCucumberTestNG {
  @Override
  public BaseTest createSpecificBaseTest() {
    return new BaseAppiumTest();
  }
}
