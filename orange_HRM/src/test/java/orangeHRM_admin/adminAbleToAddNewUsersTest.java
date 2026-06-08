package orangeHRM_admin;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.webDriverUtility;
import orangeHRM_LogIn.hrmLogintest;

public class adminAbleToAddNewUsersTest {
	
	
	@Test
	public void getLogin() throws FileNotFoundException, IOException, ParseException {
		hrmLogintest login = new hrmLogintest();
		login.getLogIn();
	}
	
	public void getAddNewUser() {
		
		webDriverUtility wdu = new webDriverUtility();
		wdu.getMaximized("");
		
	}

}
