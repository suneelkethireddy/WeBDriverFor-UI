package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg {
	
	private static WebDriver driver=null;
	
	@BeforeClass
	public static void startWebDriver(){
		
		ProfilesIni prof=new ProfilesIni();
		FirefoxProfile profile=prof.getProfile("default");
		profile.setPreference("browser.startup.homepage", "mail.google.com");
		profile.setPreference("browser.download.defaultfolder","c:\\");
		profile.setPreference("browser.download.panel.show",true);
		profile.setPreference("javascript.enabled",true);
		driver=new ChromeDriver();
		
		//driver=new HtmlUnitDriver();
	}
	
	@Test
	public void testcase(){
		driver.get("http://www.google.com");
		System.out.println("Current Url is :"+driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
		WebElement search=driver.findElement(By.id("lst-ib"));
		search.sendKeys("suneel Kumar Kethireddy");
		
		WebElement clickButton=driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		clickButton.click();
		try{
			Thread.sleep(1000);
		}catch (Exception e){
			driver.get("http://www.youtube.com");
			System.out.println("Current Url is :"+driver.getCurrentUrl());
		}
	}
	@AfterClass
	public static void stopWebDriver(){
		//driver.close();
		//driver.quit();
		if(driver!=null)
			driver=null;
	}

}
