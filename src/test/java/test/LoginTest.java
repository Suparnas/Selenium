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

import pages.GuruLogin;
import utilities.Base;
import utilities.Listeners;
import utilities.PropertyManager;
import utilities.Util;

	
//*******************************************************************
//Author: Suparna Soman
//Description: Class to test Login functionality
//*******************************************************************

	public class LoginTest extends Base{
		//*********Page Variables*********
		public static Logger Log = LogManager.getLogger(LoginTest.class.getName());
     
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			// Maximize Window
			driver.manage().window().maximize();
			String url = PropertyManager.getInstance().getURL();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
		}
		
	    @Test
		public void Login() throws Exception {
	    	
	    	GuruLogin P= new GuruLogin(driver);
	    	Util.setExcelFile(Util.FILE_PATH, Util.SHEET_NAME);
	    	 
	    	String uid, pass;
			//String actualTitle;
			String actualBoxtitle;
	    	
		    for (int i = 1; i <=Util.RowN ; i++) {
			    uid = Util.getCellData(i,1); // get username			    
			    pass = Util.getCellData(i,2); // get password
			    Log.info(i+" UserID: "+Util.getCellData(i,1)+", Password: "+Util.getCellData(i,2));
			    Listeners.test.log(LogStatus.INFO,i+" UserID: "+Util.getCellData(i,1)+", Password: "+Util.getCellData(i,2));
			    String title =PropertyManager.getInstance().gettitle();
			    String error =PropertyManager.getInstance().geterror();
		
				P.uid().clear();
				P.uid().sendKeys(uid);
				P.password().clear();
				P.password().sendKeys(pass);
				P.login().click();
				
				 try{ 
				       	Alert alt = driver.switchTo().alert();
						actualBoxtitle = alt.getText(); // get content of the Alter Message
						alt.accept();
						Assert.assertEquals(error,actualBoxtitle);
						Log.info("InValid Credentials Test Passed \n");
						Listeners.test.log(LogStatus.INFO,"InValid Credentials Test Passed \n");
				        
				 }    
				 catch (NoAlertPresentException Ex){ 
					    Assert.assertEquals(title, driver.getTitle());
						Log.info("Valid Credentials Test Passed \n" );
						Listeners.test.log(LogStatus.INFO, "Valid Credentials Test Passed \n");
						P.logout().click();
						driver.switchTo().alert().accept();

				 } 
			}  
	  }   
	    @AfterMethod
		public void teardown(){
	    	 driver.close();
		}

	}
  
				 