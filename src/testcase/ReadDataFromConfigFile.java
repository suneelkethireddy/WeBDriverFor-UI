package testcase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadDataFromConfigFile {
	
	public static WebDriver driver;
	public static WebElement element;
	
	public static void main(String[] args) throws InterruptedException {
		InputStream input=ReadDataFromConfigFile.class.getClassLoader().getResourceAsStream("testcase/config.propeties");
		Properties prop=new Properties();
			
		try {
			prop.load(input);
			String browse=prop.getProperty("browser");
				//System.out.println(browse);
			if(browse.equalsIgnoreCase("Chrome"))
				driver=new ChromeDriver();
			else if(browse.equalsIgnoreCase("InternetExplorer"))
				driver=new InternetExplorerDriver();
				//String site=prop.getProperty("url");
				//System.out.println(site);
				driver.get(prop.getProperty("url"));
			
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
			//pswd.click();
			String passwd=prop.getProperty("Password");
			pswd.sendKeys(passwd);
			
			WebElement nxt=driver.findElement(By.id("passwordNext"));
			nxt.click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
			//WebElement compose=driver.findElement(By.xpath(".//div[1]//div[1]"));
			//compose.click();
			
			Thread.sleep(3000);
	        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("suneelkumar.kethireddy@gmail.com");

	        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Automation Code ");

	        Thread.sleep(5000);

	        element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
	        element.click();
	        element.sendKeys("Hi suneel ");
	        Thread.sleep(3000);
	        driver.findElement(By.id(":nd")).click();
			
			} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

}
