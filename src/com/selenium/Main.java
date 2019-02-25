package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {
	static WebDriver driver;
	
	public static void startWebDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){
		     driver=new ChromeDriver();}
		else if(browser.equalsIgnoreCase("Firefox")){
			 driver=new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("InternetExplorer")){
			 driver=new InternetExplorerDriver();
		}
		driver.get("http://www.gmail.com"); 
	}
	public static void passingUserName() throws Exception{
		
		
		WebElement username=driver.findElement(By.id("identifierId"));
		username.sendKeys("suneel.rockstar@gmail.com");
		
		//driver.findElement(By.id("identifierNext")).click();
		
		driver.findElement(By.id("identifierNext")).click();
		//next.click();
		
		Thread.sleep(1000);
		//driver.findElement(By.id("whsOnd zHQkBf")).click();
		WebElement password1=driver.findElement(By.xpath(".//*[@id='Passwd']"));
		password1.sendKeys("babA007!");
		
		WebElement signIn=driver.findElement(By.xpath("//*[@id='signIn']"));
		signIn.click();
		
		Thread.sleep(3000);
		
		/*WebElement signOut=driver.findElement(By.xpath("//*[@id=':5j']"));
		signOut.click();*/
		
		
		username.clear();
		password1.clear();
		
	}
	public static void main(String args[]) throws Exception{
		
		startWebDriver("InternetExplorer");
		passingUserName();
	}

}
