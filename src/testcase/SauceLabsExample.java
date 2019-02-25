package testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SauceLabsExample 
{
	  public static void main(String[] args) {
	 
	    // Create an instance of the driver
	    WebDriver driver = new ChromeDriver();
	 
	    // Navigate to a web page
	    driver.get("http://www.foo.com");
	 
	    // Perform actions on HTML elements, entering text and submitting the form
	    WebElement usernameElement     = driver.findElement(By.name("username"));
	    WebElement passwordElement     = driver.findElement(By.name("password"));
	    WebElement formElement        = driver.findElement(By.id("loginForm"));
	 
	    usernameElement.sendKeys("Alan Smithee");
	    passwordElement.sendKeys("twilightZone");
	 
	    //passwordElement.submit(); // submit by text input element
	    formElement.submit();        // submit by form element
	 
	 
	    // Anticipate web browser response, with an explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(
	           ExpectedConditions.presenceOfElementLocated(By.id("loginResponse"))
	            );
	 
	    // Run a test
	    String message                 = messageElement.getText();
	    String successMsg             = "Welcome to foo. You logged in successfully.";
	    Assert.assertEquals (message, successMsg);
	 
	    // Conclude a test
	    driver.quit();
	 
	  }

}
