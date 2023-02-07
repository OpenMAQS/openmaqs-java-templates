package com.company.automation.test;

import io.github.openmaqs.cucumber.BaseSeleniumCucumber;
import io.cucumber.testng.CucumberOptions;

/**
 * Selenium glue.
 */
@CucumberOptions( glue = {"com.company.automation.test.stepdefs"}, plugin = {"pretty"}, features = {"src/test/resources/selenium"})
public class TestRunnerSelenium extends BaseSeleniumCucumber {

}