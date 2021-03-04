package com.automation.driver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@SuppressWarnings("unused")
class CHDriver implements IDriver

{

	private static int PageLoadTimeOut = 0;
	private static int ImlicitWaitTimeout = 0;
	private static ChromeDriverService chService = null;
	public static WebDriver driver = null;

	CHDriver() {
		PageLoadTimeOut = BasicConstants.PAGE_LOAD_TIME_OUT;
		ImlicitWaitTimeout = BasicConstants.IMPLICIT_WAIT_TIMEOUT;

	}

	public void startDriver() {
		try {
			String ChromeDriverServer = System.getProperty("user.dir") + "/browserserver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromeDriverServer);

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			/*
			 * Proxy proxy = new Proxy();
			 * proxy.setProxyAutoconfigUrl("http://newproxy.ah.nl:8000/kpn.pac")
			 * ; //proxy.setHttpProxy("localhost:8888"); //Add the proxy to our
			 * capabilities capabilities.setCapability("proxy", proxy);
			 */

			// --------------------------- To enable
			// Flash-----------------------------------------------------------------------

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("profile.default_content_setting_values.plugins", 1);
			prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			options.addArguments("disable-infobars");

			// options.addArguments("--incognito");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--allow-insecure-websocket-from-https-origin");
			options.addArguments("disable-extensions");
			options.addArguments("allow-running-insecure-content");
			options.addArguments("--start-maximized");
			options.addArguments("disable-extensions");
			options.addArguments("disable-plugins");
			options.addArguments("--enable-precise-memory-info");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("useAutomationExtension", false);
			DesiredCapabilities cap = new DesiredCapabilities();
			/* cap.setCapability(ChromeOptions.CAPABILITY, options); */
			options.merge(cap);
			driver = new ChromeDriver(options);
			// driver = new RemoteWebDriver(new
			// URL("http://10.201.165.149:4444/wd/hub"),capabilities);
			// driver = new RemoteWebDriver(new
			// URL("http://10.135.15.67:4444/wd/hub"),capabilities);
			// driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(PageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(ImlicitWaitTimeout, TimeUnit.SECONDS);
			// System.out.println("********************************************************");
			// System.out.println();

		}catch (Exception e)
		{

		}
	}

	// To stop the driver
	public void stopDriver() {
		try {
			driver.close();
			// driver.quit();
		} catch (Exception e) {
			// log.fatal("Exception while stopping the driver\n" +
			// e.getMessage());
		} finally {
			driver = null;
		}
	}

	// To start the driver

	public WebDriver get() {

		if (null == driver)
		{
			this.startDriver();
		}
		return driver;
	}

}