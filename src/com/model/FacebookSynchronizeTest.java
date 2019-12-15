package com.model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSynchronizeTest
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\11092019\\chrome_78\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		//pageLoadTimeOut
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		//Implicit wait
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Suvidya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Pawaskar");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("suvidyapawaskar@gmail.com");
		
		//Explicit wait		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
		
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("suvidyapawaskar@gmail.com");
		
		
			
	}

}
