package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingP {

	public WebDriver drvr;
	
	public landingP(WebDriver drvr) {
		this.drvr = drvr;
	}
	
	By btnsignin = By.cssSelector("a[href*='sign_in']");
	public WebElement getLogin() {
		return drvr.findElement(btnsignin);
	}
	
	/*
	By featheader = By.cssSelector(".text-center>h2");
	public WebElement getHead() {
		return drvr.findElement(featheader); 
	}
	*/
	
	By navbar = By.xpath("//nav[@class='navbar-collapse collapse']");
	public WebElement getNav() {
		return drvr.findElement(navbar);
	}
	
	By popup = By.xpath("//div[@class='listbuilder-popup-content']");
	public WebElement getPop() {
		return drvr.findElement(popup);
	}
	
	By closepop = By.xpath("//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-outside-horizontal-resize-handles sumome-react-wysiwyg-outside-vertical-resize-handles sumome-react-wysiwyg-close-button sumome-react-wysiwyg-popup-image sumome-react-wysiwyg-image']");
	public WebElement getClosePop() {
		return drvr.findElement(closepop);
	}
	
}
