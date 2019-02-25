package com.selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Login1 {

	
@Test
public void logInToGmail() {

WebDriver driver = new ChromeDriver();
//  Wait For Page To Load
// Put a Implicit wait, this means that any search for elements on the page
//could take the time the implicit wait is set for before throwing exception 
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Navigate to URL
driver.get("https://gmail.com/");

try {
	Thread.sleep(2000);

// Maximize the window.
//driver.manage().window().maximize();
// Enter UserName
	WebElement next=driver.findElement(By.id("identifierNext"));
driver.findElement(By.id("Email")).sendKeys("**************_**********@gmail.com");

next.click();
//driver.findElement(By.id("identifierNext")).click();
//next.click();
// Enter Password
driver.findElement(By.id("Passwd")).sendKeys("**************");
// Wait For Page To Load
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
// Click on 'Sign In' button
driver.findElement(By.id("signIn")).click();
//Click on Compose Mail.
driver.findElement(By.xpath("//div[@class='z0']/div")).click();
// Click on the image icon present in the top right navigational Bar
driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).click();
//Click on 'Logout' Button
driver.findElement(By.xpath("//*[@id='gb_71']")).click();
//Close the browser.
driver.close();
} catch (InterruptedException e) {
	e.printStackTrace();
}
}
}