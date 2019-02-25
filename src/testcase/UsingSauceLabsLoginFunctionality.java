package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsingSauceLabsLoginFunctionality {
	
	public WebDriver driver;
	public final String USERNAME="suneel.rockstar@gmail.com";
	public final String ACCESS_KEY="a530225e-2003-4fbb-a267-fde18d792d9d";
	public final String URL="https://suneel.rockstar@gmail.com:a530225e-2003-4fbb-a267-fde18d792d9d@ondemand.saucelabs.com:443/wd/hub";
	
	@BeforeClass
	public  void startWebDriver(){
		
		ProfilesIni prof=new ProfilesIni();
		FirefoxProfile profile=prof.getProfile("default");
		profile.setPreference("browser.startup.homepage", "mail.google.com");
		profile.setPreference("browser.download.defaultfolder","c:\\");
		profile.setPreference("browser.download.panel.show",true);
		profile.setPreference("javascript.enabled",true);
		//driver=new ChromeDriver();
		driver=new HtmlUnitDriver();
		DesiredCapabilities	capabilities = DesiredCapabilities.chrome();
		
		capabilities.setCapability("platform", "OS X 10.9 ");
		capabilities.setCapability("version", "7.0");
		
		
	}
	
	@Test
	public void testcase(){
		driver.get("http://www.google.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Current Url is :"+driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");
		WebElement search=driver.findElement(By.id("lst-ib"));
		search.sendKeys("suneel Kumar Kethireddy");
		
		WebElement clickButton=driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		clickButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass 
	public  void stopWebDriver(){
		//driver.close();
		driver.quit();
		//if(driver!=null)
			//driver=null;
	}


}
