package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverUtility {
	
	WebDriver driver ;
	
	public void getMaximized(String browser) {
		if(browser.equals("chrome")) {
    		driver = new ChromeDriver();
    	}else if (browser.equals("edge")) {
    		driver = new EdgeDriver();
    	}else if (browser.equals("firefox")) {
    		driver = new FirefoxDriver();
    	}else {
    		driver = new ChromeDriver();
    	}
	}
	
	public void getImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
