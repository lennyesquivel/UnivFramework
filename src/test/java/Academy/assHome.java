package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.landingP;
import resources.baseDrvrs;

public class assHome extends baseDrvrs {
	
	public Logger log=LogManager.getLogger(baseDrvrs.class.getName());
	
	@BeforeTest
	public void initD() throws IOException {
		drvr=initDrvr();
		log.info("Driver initialized");
		drvr.manage().deleteAllCookies();
		
	}
	
	@Test
	public void assertTest() throws IOException {
		
		drvr.get(props.getProperty("url"));
		
		landingP lp = new landingP(drvr);
		Assert.assertTrue(lp.getNav().isDisplayed());
		log.info("Top Nav is displayed");
		
	}
	
	@AfterTest
	public void shutd() {
		drvr.close();
		drvr=null;
	}
	
}
