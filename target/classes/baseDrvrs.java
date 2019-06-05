package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class baseDrvrs {
	
	public static WebDriver drvr;
	public Properties props;
	Timestamp ts;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-HH_mm_ss");
	
	public WebDriver initDrvr() throws IOException {
	
		props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Training\\eclipse-workspace\\Project\\src\\main\\java\\resources\\props.properties");
		
		props.load(fis);
		String pbrowser = props.getProperty("browser");
		String pdriv = props.getProperty("driver");
		String ppath = props.getProperty("driverPath");
		int waittime = Integer.parseInt(props.getProperty("implicitWaitTime"));
		
		if(pbrowser.equals("chrome")) {
			System.setProperty(pdriv,ppath);
			drvr = (WebDriver) new ChromeDriver();
		}else if(pbrowser.equals("firefox")) {
			drvr = (WebDriver) new FirefoxDriver();
		}else if(pbrowser.equals("ie")) {
			drvr = (WebDriver) new InternetExplorerDriver();
		}
		
		drvr.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
		return drvr;
		
	}
	
	public void getScreenshot(String testname) throws IOException {
		ts = new Timestamp(System.currentTimeMillis());
		File src = ((TakesScreenshot)drvr).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\Training\\Desktop\\"+testname+sdf.format(ts)+".png"));
	}

}
