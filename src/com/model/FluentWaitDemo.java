package com.model;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class FluentWaitDemo 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","F:\\11092019\\chrome_78\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@onclick='myFunction()'][.='Click Me - Fluent Wait']")).click();
		
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		WebElement element1=wait.until(new Function<WebDriver,WebElement>()
				{
					@Override
					public WebElement apply(WebDriver driver)
					{
					    WebElement msgelement=driver.findElement(By.xpath("//p[contains(text(),'Software Testing Material - DEMO PAGE')]"));
					    String msgtext=msgelement.getText();
					    if(msgtext.equalsIgnoreCase("Software Testing Material - DEMO PAGE"))
					    {
					    	System.out.println(msgtext);
					    	return msgelement;
					    }else
					    {
					    return null;
					    }
					}
				
				
				}
				);
		
		
		
         
	}

}
