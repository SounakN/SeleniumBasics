package com.automation.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;





class IEDriver implements IDriver 

{

	//Logger
	//Logger log = Logger.getLogger(IEDriver.class);
	
	private static int PageLoadTimeOut =0; 
	private static int ImlicitWaitTimeout=0;
	private static InternetExplorerDriverService ieService = null;
	private static WebDriver driver = null;
	
	
	// To set the page load timeout
	IEDriver()
	{
		PageLoadTimeOut = BasicConstants.PAGE_LOAD_TIME_OUT;
		ImlicitWaitTimeout=BasicConstants.IMPLICIT_WAIT_TIMEOUT;
	}
	
	// To start the service
	

	// To start the driver
	public void startDriver() 
	{
		String IEDriverServer = System.getProperty("user.dir") + "/browserserver/IEDriverServer.exe";



		System.setProperty("webdriver.ie.driver", IEDriverServer);
		
		
		  DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	        capab.setCapability(
	            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	            true);
	        capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
	        capab.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
	        capab.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
	        capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        capab.setCapability(InternetExplorerDriver.IE_SWITCHES, true);
	        driver = new InternetExplorerDriver(capab);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(ImlicitWaitTimeout, TimeUnit.MILLISECONDS);
	}

	// To stop the driver
	public void stopDriver() 
	{
		try
		{
			driver.close();
			//driver.quit();
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

	// To check whether service is running or not
	public boolean isServiceRunning() {
		if(null!=ieService)
			return true;
		else
			return false;
	}

}