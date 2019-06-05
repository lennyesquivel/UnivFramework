package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingP;
import pageObjects.loginP;
import resources.baseDrvrs;

public class HomePage extends baseDrvrs {
	
	public Logger log=LogManager.getLogger(baseDrvrs.class.getName());
	
	@BeforeTest
	public void initD() throws IOException {
		drvr=initDrvr();
		log.info("Driver initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNav(String usern, String passw, String usertype){
		
		drvr.get(props.getProperty("url"));
		drvr.manage().deleteAllCookies();
		landingP lp = new landingP(drvr);
		if(popupPres()) {
			lp.getClosePop().click();
			log.info("Lightbox PopUp closed");
		}
		lp.getLogin().click();
		
		loginP lgp = new loginP(drvr);
		lgp.getEmail().sendKeys(usern);
		lgp.getPass().sendKeys(passw);
		log.info(usertype);
		lgp.getBtnLog().click();

	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][3];
		obj[0][0]="lenny@kfaihdfb.com";
		obj[0][1]="123";
		obj[0][2]="Common user";
		
		obj[1][0]="lenny2@kfaihdfb.com";
		obj[1][1]="12345";
		obj[1][2]="Uncommon user";
		
		return obj;
	}
	
	@AfterTest
	public void teardown() {
		drvr.close();
		drvr=null;
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
