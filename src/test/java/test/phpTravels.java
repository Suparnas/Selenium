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
import pages.TravelsPage;
import utilities.Base;
import utilities.Listeners;
import utilities.PropertyManager;
import utilities.Util;

	
//*******************************************************************
//Author: Suparna Soman
//Description: Class to test Login functionality
//*******************************************************************

	public class phpTravels extends Base{
		//*********Page Variables*********
		public static Logger Log = LogManager.getLogger(phpTravels.class.getName());
     
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			// Maximize Window
			driver.manage().window().maximize();
			String url = PropertyManager.getInstance().getURL1();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(url);
		}
		
	    @Test
		public void Login() throws Exception {
	    	
	    	TravelsPage P= new TravelsPage(driver);
	    	 
	    	
			//String actualBoxtitle;
	    	
		    
		P.getcancel().click();
		P.getnSub().click();
		P.getnbut().click();
		  
	  }   
	    @AfterMethod
		public void teardown(){
	    	 driver.close();
		}

	}
  
				 