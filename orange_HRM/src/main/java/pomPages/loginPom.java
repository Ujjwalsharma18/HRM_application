package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class loginPom {
	
	public loginPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	public WebElement getUn() {
		return username;		
	}
	
	@FindBy(name="password")
	private WebElement password;
	
	public WebElement getPwd() {
		return password;
	}
	
	@FindBy(css ="button[type='submit']")
	private WebElement loginbtn;
	
	public WebElement getloinbtn() {
		return loginbtn;
	}
	
	public void login(String un ,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	

}
