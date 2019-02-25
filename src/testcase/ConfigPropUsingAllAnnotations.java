package testcase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class ConfigPropUsingAllAnnotations {
	
	public InputStream input;
	public Properties prop;
	public WebDriver driver;
	public WebElement element;
	
	@BeforeClass
	public void fetchData(){
		input=ReadDataFromConfigFile.class.getClassLoader().getResourceAsStream("testcase/config.propeties");
		prop=new Properties();
	}
	
	@Test
	public void loadBrowser() throws IOException{
		
			prop.load(input);
		
		String browse=prop.getProperty("browser");
		//System.out.println(browse);
	if(browse.equalsIgnoreCase("Chrome"))
		driver=new ChromeDriver();
	else if(browse.equalsIgnoreCase("InternetExplorer"))
		driver=new InternetExplorerDriver();
	}
	
	@Test(dependsOnMethods="loadBrowser")
	public void getURL(){
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dependsOnMethods="getURL")
	public void getLoginCredentials(){
		try{
			WebElement username=driver.findElement(By.id("identifierId"));
			String MailId=prop.getProperty("Username");
			username.sendKeys(MailId);
			
			WebElement next=driver.findElement(By.id("identifierNext"));
			next.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
					
			WebElement pswd=driver.findElement(By.xpath("//input[@type='password']"));
			String passwd=prop.getProperty("Password");
			pswd.sendKeys(passwd);
			
			WebElement nxt=driver.findElement(By.id("passwordNext"));
			nxt.click();
			Thread.sleep(2000);
			}
			catch(ElementNotFoundException e){
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test(dependsOnMethods="getLoginCredentials")
		public void composeFunctionality(){
			
			driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
			//WebElement compose=driver.findElement(By.xpath(".//div[1]//div[1]"));
			//compose.click();
				
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("suneelkumar.kethireddy@gmail.com");

	        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Automation Code ");

	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
	        element.click();
	        element.sendKeys("Hi suneel ");
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        driver.findElement(By.id(":nd")).click();
		}
		@AfterClass
		public void closeBrowser(){
			driver.close();
		}

}
