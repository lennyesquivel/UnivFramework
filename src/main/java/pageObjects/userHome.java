package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userHome {
	
	public WebDriver drvr;
	
	public userHome(WebDriver drvr) {
		this.drvr = drvr;
	}
	
	By myCourses = By.id("search-courses");
	public WebElement getCourses() {
		return drvr.findElement(myCourses);
	}

}
