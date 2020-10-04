package com.Base;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	protected WebDriver driver = null;
	ChromeOptions options = new ChromeOptions();
	public BaseClass()
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().browserVersion("86.0.4240.22").setup();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
	}
	public WebDriver openBrowser(String browesrName)
	{
		switch (browesrName) {
		case "Chrome":
			driver = new ChromeDriver(options); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		default:
			return null;
		}
	}
}
