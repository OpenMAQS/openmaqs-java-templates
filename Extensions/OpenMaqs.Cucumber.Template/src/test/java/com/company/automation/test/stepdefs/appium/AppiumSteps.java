package com.company.automation.test.stepdefs.appium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppiumSteps extends BaseAppiumStep{

  @Given("Appium Step")
  public void appiumStep() {
    this.getDriver().navigate().to("https://magenicautomation.azurewebsites.net/");
    this.getLogger().logMessage("info");
  }

  @When("Appium Step2")
  public void appiumStep2() {
    this.getLogger().logMessage("Step2");
  }

  @Then("Appium Step3")
  public void appiumStep3() {
    this.getLogger().logMessage("Step3");
  }
}
