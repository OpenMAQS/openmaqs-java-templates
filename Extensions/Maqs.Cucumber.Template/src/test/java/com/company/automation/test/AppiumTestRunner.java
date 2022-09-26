package com.company.automation.test;

import io.cucumber.testng.CucumberOptions;

/**
 * Selenium glue.
 */
@CucumberOptions( glue = {"com.company.automation.test.stepdefs.appium"}, plugin = {"pretty"}, features = {"src/test/resources/appium"})
public class AppiumTestRunner extends BaseAppiumCucumber{
}
