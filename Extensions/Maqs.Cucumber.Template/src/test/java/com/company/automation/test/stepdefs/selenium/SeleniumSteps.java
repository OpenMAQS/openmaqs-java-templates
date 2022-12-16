/*
 * Copyright 2022 (C) MAQS, All rights Reserved
 */

package com.company.automation.test.stepdefs.selenium;

import io.github.maqs.cucumber.steps.BaseSeleniumStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumSteps extends BaseSeleniumStep {

    @Given("^Selenium Step$")
    public void Step() {
        this.getDriver().navigate().to("https://magenicautomation.azurewebsites.net/");
        this.getLogger().logMessage("info");
    }

    @When("Selenium Step2")
    public void Step2() {
        this.getLogger().logMessage("Step2");
    }

    @Then("Selenium Step3")
    public void Step3() {
        this.getLogger().logMessage("Step3");
    }
}
