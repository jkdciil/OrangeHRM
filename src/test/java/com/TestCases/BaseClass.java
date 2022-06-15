package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	
	public WebDriver driver;
    @BeforeTest
	public void Chrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\projects\\OrangeHRM\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MICROSECONDS);
	}
    @Test
    public void enter()
    {
    	WebElement ele1=driver.findElement(By.id("txtUsername"));
    	ele1.sendKeys("Admin");
    	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    	driver.findElement(By.id("btnLogin")).click();
    	String gc=driver.getCurrentUrl();
    	String ac="https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
    	System.out.println(gc);
    	SoftAssert sa=new SoftAssert();
    	sa.assertEquals(gc, ac);
    	
    	
    	
    }
    @AfterTest
    public void close()
    {
    	//driver.close();
    }
}
