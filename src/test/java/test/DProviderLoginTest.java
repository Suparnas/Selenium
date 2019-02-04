package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.GuruLogin;
import utilities.Base;
import utilities.Listeners;
import utilities.PropertyManager;
import utilities.Util;

	
//*******************************************************************
//Author: Suparna Soman
//Description: Class to test Login functionality
//*******************************************************************

	public class DProviderLoginTest extends Base{
		 Listeners B = new Listeners();

		//*********Page Variables*********
		public static Logger Log = LogManager.getLogger(DProviderLoginTest.class.getName());
     
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			//Listeners.test.log(LogStatus.INFO,"Driver is initialized");
			// Maximize Window
			driver.manage().window().maximize();
			String url = PropertyManager.getInstance().getURL();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
		}
		
	    @Test (dataProvider ="Logins")
		public void DProviderLogin(String Username, String Password) throws Exception {
	    	
	    	GuruLogin P= new GuruLogin(driver);
			String actualBoxtitle;
	    	String title =PropertyManager.getInstance().gettitle();
			String error =PropertyManager.getInstance().geterror();
			   
			// Enter valid UserId
			P.uid().clear();
			P.uid().sendKeys(Username);
			// Enter valid Password
			P.password().clear();
			P.password().sendKeys(Password);
			// Click Login
			P.login().click();
				
			try{ 
				Alert alt = driver.switchTo().alert();
				actualBoxtitle = alt.getText(); // get content of the Alter Message
				alt.accept();
				Assert.assertEquals(error,actualBoxtitle);
				Listeners.test.log(LogStatus.INFO,"InValid Credentials Test Passed \n");
				Log.info("InValid Credentials Test Passed \n");
			 }    
			 catch (NoAlertPresentException Ex){ 
			 
				String Logid = P.loggid().getText();
				String[] parts = Logid.split(Util.PATTERN);
				String dynamicText = parts[1];
				
				// Check that the dynamic text is of pattern mngrXXXX
				// First 4 characters must be "mngr"
				Assert.assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
				// remain stores the "XXXX" in pattern mngrXXXX
				String remain = dynamicText.substring(dynamicText.length() - 4);
				// Check remain string must be numbers;
				Assert.assertTrue(remain.matches(Util.SECOND_PATTERN));
				
				Assert.assertEquals(title, driver.getTitle());
				Listeners.test.log(LogStatus.INFO,"Valid Credentials Test Passed \n" );
				Log.info("Valid Credentials Test Passed \n" );
				//getScreenshot();
				
				P.logout().click();
				driver.switchTo().alert().accept();
			 } 
			
	    }
			 
	    @DataProvider(name="Logins")
	    public Object[][] dataProvider(){
	    return new Object[][] 
	    	{
	    		{ "mngr171835", "EnygEve" },
	            { "invalid", "EnygEve" },
	            { "mngr171835", "invalid" },
	            { "invalid" , "invalid" }
	        };
	    }
	    
	    @AfterMethod
		public void teardown(){
	    	 driver.close();
		}
	    
	}
  
				 