package com.automation.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.StepDefinitions.SetUp;
import com.automation.utilities.ActionMethods;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class PageObjects_LoginPage {
	
	protected WebDriver driver ;
	public ActionMethods user = new ActionMethods();
	public PageObjects_HomePage POhomepage = null;
	
	@FindBy(how=How.ID , using = "logInPanelHeading")
	public WebElement LoginHeadPannel;
	
	@FindBy(how=How.XPATH , using = "//div[@id='divUsername']/input[@name='txtUsername' or @id = 'txtUsername']")
	public WebElement Username;
	
	@FindBy(how=How.XPATH , using = "//div[@id='divPassword']/input[@name='txtPassword' or @id = 'txtPassword']")
	public WebElement Password;
	
	@FindBy(how=How.XPATH , using = "//div[@id='divLoginButton']/input[@type='submit']")
	public WebElement Submit;

	public PageObjects_LoginPage(WebDriver driver1)	{
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean getHeader() {
		try {
		Boolean check=user.isWebElementPresent(LoginHeadPannel,driver);
		return check;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public String getTitle() {
		try {
		String title = driver.getTitle();
		return title;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public PageObjects_HomePage LogintoHomepage(String Username1, String Password1) throws InterruptedException {

		Username.sendKeys(Username1);
		Password.sendKeys(Password1);
		Thread.sleep(3000);
		Submit.click();
		POhomepage = new PageObjects_HomePage();
		
		return POhomepage;
	}
}
	
	