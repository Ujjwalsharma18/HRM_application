package orangeHRM_LogIn;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtility.fileUtilities;
import pomPages.loginPom;

public class hrmLogintest {
	
	
	@Test
	public void getLogIn() throws FileNotFoundException, IOException, ParseException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
////		object of fileUtility-----
		fileUtilities files = new fileUtilities();
	      String URL =	files.getDataFromJsonFile("url");
	      String USERNAME =	files.getDataFromJsonFile("un");
	      String PASSWORD =	files.getDataFromJsonFile("pwd");
		
	    	driver.get(URL);
//	    	
////	    	object of pomPages---------
	    	loginPom lg = new loginPom(driver);
	    	
	    	lg.login(USERNAME, PASSWORD);
//	    	 
//	    	driver.quit();
		
		
	}	
	

}
