package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebInterface {
	public static WebDriver driver=null;
	
	
	public static void main(String args[]){
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		
		driver=new InternetExplorerDriver();
	}
}
