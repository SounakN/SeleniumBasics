package com.automation.StepDefinitions;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.automation.PageObjects.PageObjects_HomePage;
import com.automation.utilities.ActionMethods;

import io.cucumber.java.en.Then;

public class StepDef_Homepage {

	public ActionMethods user = new ActionMethods();

	@Then("Verify that you are in Homepage")
	public void Verify_that_you_are_in_Homepage() {
		try {
		PageObjects_HomePage a = new PageObjects_HomePage();
		Boolean check = a.verifypresenceofheader();
		Assert.assertTrue(check);
		user.embedScreenshot(SetUp.driver, SetUp.Sc, "Succesfully the hoempage is loged in to");
		}catch(Exception e)
		{
			
		}
	}

}
