package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginP {

	public WebDriver drvr;
	
	public loginP(WebDriver drvr) {
		this.drvr = drvr;
	}
	
	By inpmail = By.id("user_email");
	public WebElement getEmail() {
		return drvr.findElement(inpmail);
	}
	
	By inppass = By.id("user_password");
	public WebElement getPass() {
		return drvr.findElement(inppass);
	}
	
	By btnLog = By.cssSelector("input[value*='Log In']");
	public WebElement getBtnLog() {
		return drvr.findElement(btnLog);
	}
	
}
