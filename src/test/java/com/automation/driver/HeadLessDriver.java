package com.automation.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;





class HeadLessDriver implements IDriver 

{

	//Logger
	//Logger log = Logger.getLogger(HeadLessDriver.class);

	private static long PageLoadTimeOut =0; 

	private static WebDriver driver = null;

	// To decide page load timeout

	HeadLessDriver()
	{
		PageLoadTimeOut = BasicConstants.PAGE_LOAD_TIME_OUT;
	}




	public void startDriver() 
	{
		/*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		driver = new InternetExplorerDriver(ieService, ieCapabilities);*/

		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
	}



	// To stop the driver

	public void stopDriver() 
	{
		try
		{
			driver.close();
			driver.quit();
		}
		catch(Exception e)
		{
			//log.fatal("Exception while stopping the driver\n" + e.getMessage());
		}
		finally
		{
			driver = null;
		}
	}


	public WebDriver get() 
	{
		if(null==driver)
			this.startDriver();

		return driver;
	}

}