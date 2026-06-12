package orangeHRM_admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import baseUtility.baseClass;
import genericUtility.fileUtilities;
import genericUtility.webDriverUtility;
import orangeHRM_LogIn.hrmLogintest;
import pomPages.loginPom;

@Listeners(listeners_Utility.impl_listener.class)
public class adminAbleToSearchUserTest extends baseClass {

	@Test
	public void getAddNewUserByAdmin() throws FileNotFoundException, IOException, ParseException, InterruptedException {


		ExtentTest test = report.createTest("createContactTest");
		
		// ==============================
		// Navigate to Admin Module
		// ==============================
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//label[text()='Username']/../..//input")).sendKeys("Admin");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	  WebElement validation =	driver.findElement(By.xpath("//div[text()='Admin']"));
	  
	  if(validation.isDisplayed()) {
		  System.out.println("we got the employee name !!");
	  }
				  
	}

}
