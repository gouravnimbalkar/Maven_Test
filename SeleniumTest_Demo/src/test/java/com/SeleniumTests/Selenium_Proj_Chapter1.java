package com.SeleniumTests;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Object_Repository.WebElement_Repository_Chapter1;

import com.Base.BaseClass;

public class Selenium_Proj_Chapter1 {
	WebDriver driver = null;
	@BeforeClass()
	public void setup()
	{
		System.out.println("In class");
		BaseClass bc = new BaseClass();
		driver = bc.openBrowser("Chrome");
		new WebElement_Repository_Chapter1(driver);
	}
	@Test
	public void Test1()
	{
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter1");
		String actualText = WebElement_Repository_Chapter1.getText();
		try
		{
			Assert.assertEquals(actualText,"Assert that this text is on the page");
		}
		catch(Exception ex)
		{
			System.out.println("Validation failed with an error :"+ex.getMessage());
		}
		
	}
	@Test
	public void Test2()
	{
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter1");
		boolean flag = WebElement_Repository_Chapter1.IsButtonVisible();
		try
		{
			Assert.assertEquals(flag,true);
		}
		catch(Exception ex)
		{
			System.out.println("Validation failed with an error :"+ex.getMessage());
		}		
	}
	@Test
	public void Test3()
	{
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter1");
		String actualText = WebElement_Repository_Chapter1.loadText();
		try
		{
			Assert.assertEquals(actualText, "I have been added with a timeout");
		}
		catch(Exception ex)
		{
			System.out.println("Validation failed with an error :"+ex.getMessage());
		}
		
	}
	@Test
	public void Test4()
	{
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter1");
		WebElement_Repository_Chapter1.clickNewWindowpopup(driver);
	}
	@Test
	public void Test5()
	{
		driver.navigate().to("http://book.theautomatedtester.co.uk/chapter1");
		WebElement_Repository_Chapter1.hover(driver);
	}
	
	@AfterClass
	public void Cleanup()
	{
		//driver.close();
	}
}
