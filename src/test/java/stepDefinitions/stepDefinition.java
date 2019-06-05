package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.landingP;
import pageObjects.loginP;
import pageObjects.userHome;
import resources.baseDrvrs;

@RunWith(Cucumber.class)
public class stepDefinition extends baseDrvrs {
	
	public Logger log=LogManager.getLogger(baseDrvrs.class.getName());
	landingP lp;
	loginP lgp;
	userHome uh;
		
	@Before
	public void initDrv() throws IOException {
		drvr=initDrvr();
		log.info("Driver initialized");
		
		lp = new landingP(drvr);
		lgp = new loginP(drvr);
		uh = new userHome(drvr);
	}
	
	@Given("user is on banking landing page")
	public void user_is_on_banking_landing_page() {
		drvr.get(props.getProperty("url"));
	}
	
	@When("^user logs in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_logs_in_with_user_something_and_password_something(String strArg1, String strArg2) {
		if(popupPres()) {
			lp.getClosePop().click();
			log.info("Lightbox PopUp closed");
		}
		lp.getLogin().click();
		
		lgp.getEmail().sendKeys(strArg1);
		lgp.getPass().sendKeys(strArg2);
		lgp.getBtnLog().click();
    }
	
	@Then("^login is \"([^\"]*)\"$")
    public void login_is_something(String strArg1) throws Throwable {
		try {
			Boolean response = uh.getCourses().isDisplayed();
			String verif;
			if(response) {
				verif="true";
			}else {
				verif="false";
			}
			assertEquals(strArg1,verif);
			log.info("Login successful");
		}catch(Exception e) {
			log.info("Login unsuccessful");
		}
	}
	
	@After
	public void afterTests() {
		drvr.close();
	}
	
	public boolean popupPres() {
		try {
			log.info("Lightbox PopUp found");
			drvr.findElement(By.xpath("//div[@class='listbuilder-popup-content']")).isDisplayed();
			return true;
		}catch(NoSuchElementException Ex) {
			log.info("Lightbox PopUp not found");
			return false;
		}
	}

}
