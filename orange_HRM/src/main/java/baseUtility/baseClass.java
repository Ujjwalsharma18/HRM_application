package baseUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.core.ParseException;
import genericUtility.fileUtilities;
import pomPages.loginPom;

public class baseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public ExtentReports report;

//	@BeforeSuite
//	public void repConfig() {
////		report config
//		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/oramgeHRM.html");
//		spark.config().setDocumentTitle("orange_HRM");
//		spark.config().setReportName("first report");
//		spark.config().setTheme(Theme.DARK);                             // now this part(beforeSuits) add to listeners
//
//		report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("key1", "value1");
//		report.setSystemInfo("key2", "value2");
//		report.setSystemInfo("key3", "value3");
//	}

	@BeforeClass
	public void setUp()
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		// ==============================
		// Browser Setup
		// ==============================

//		get data from json file
		fileUtilities fUtil = new fileUtilities();
		String BROWSER = fUtil.getDataFromJsonFile("url");


		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver = driver;
//		driver = new ChromeDriver();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void login()
			throws FileNotFoundException, IOException, ParseException, org.json.simple.parser.ParseException {
		// ==============================
		// Login to HRM Application
		// ==============================
		fileUtilities fUtil = new fileUtilities();
		String URL = fUtil.getDataFromJsonFile("url");
		String USERNAME = fUtil.getDataFromJsonFile("un");
		String PASSWORD = fUtil.getDataFromJsonFile("pwd");

		driver.get(URL);
		loginPom lp = new loginPom(driver);
		lp.login(USERNAME, PASSWORD);

		System.out.println("Login successful");
	}
//===========================
	@AfterMethod
	public void logout() {
		// ==============================
		// Logout from HRM Application
		// ==============================

		driver.findElement(By.cssSelector("span[class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		System.out.println("Logout successful");
	}

	@AfterClass
	public void tearDown() {
		// ==============================
		// Close Browser
		// ==============================

		driver.quit();
		System.out.println("Browser closed successfully");
	}

//	@AfterSuite
//	public void repBackup() {              // add this part(after suit to Listeners)
//		report.flush();
//	}

}
