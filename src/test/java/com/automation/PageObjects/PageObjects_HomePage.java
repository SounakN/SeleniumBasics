package com.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.StepDefinitions.SetUp;
import com.automation.utilities.ActionMethods;

public class PageObjects_HomePage {

	protected WebDriver driver = SetUp.driver;
	public ActionMethods user = new ActionMethods();
	@FindBy(how=How.XPATH , using = "//a[text()='Welcome Paul']")
	public WebElement PageVerification;
	
	
	public PageObjects_HomePage()	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifypresenceofheader()
	{
		try {
		Boolean check = user.isWebElementPresent(PageVerification, driver);
		return check;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
