package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//*******************************************************************
//Author: Suparna Soman
//Description: Base class defines the basic drivers for all the tests
//*******************************************************************

public class Base {

	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("./src/main/resources/data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	//Execute in Chrome Driver
	driver= new ChromeDriver(); 
}

else if (browserName.equals("firefox"))
{
	//Execute in Firefox Driver
	driver= new FirefoxDriver();
}

else if (browserName.equals("IE"))
{
	//Execute in IE Driver
	 driver= new InternetExplorerDriver();
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}

public void getScreenshot(String result) throws IOException
{
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File(result+"screenshot.png"));
}

}

	
	

