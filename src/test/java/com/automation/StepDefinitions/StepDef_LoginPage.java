package com.automation.StepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automation.PageObjects.PageObjects_HomePage;
import com.automation.PageObjects.PageObjects_LoginPage;
import com.automation.utilities.ActionMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDef_LoginPage {

	public ActionMethods user = new ActionMethods();
	
	@Given("That user is in LoginPage")
	public void that_user_is_in_LoginPage() {
		try {
		PageObjects_LoginPage a = new PageObjects_LoginPage(SetUp.driver);
		Boolean check = a.getHeader();
		
		Assert.assertTrue(check);
		System.out.println("Header matched");}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			Assert.fail(e.getMessage());
			
		}
	}

	@Then("Verify that the Title {string} matches with it")
	public void verify_that_the_Title_matches_with_it(String string) {
		PageObjects_LoginPage a = new PageObjects_LoginPage(SetUp.driver);
		String title=a.getTitle();
		Assert.assertTrue("They should match", title.equalsIgnoreCase(string));
		System.out.println("They matched");
	}

	@Then("login with the {string} and {string}")
	public void login_with_the_and(String string, String string2) throws InterruptedException {
		PageObjects_LoginPage a = new PageObjects_LoginPage(SetUp.driver);
		PageObjects_HomePage b = a.LogintoHomepage(string, string2);
		System.out.println("CHeck");
		
	}



}
