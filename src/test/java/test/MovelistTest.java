package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DualListBox;
import utilities.Base;
import utilities.Listeners;

//*******************************************************************
//Author: Suparna Soman
//*******************************************************************

public class MovelistTest extends Base
 {
			public static Logger Log = LogManager.getLogger(MovelistTest.class.getName());
		    
			@BeforeMethod
			public void initialize() throws IOException {
				driver = initializeDriver();
				Log.info("Driver is initialized");
				driver.get(prop.getProperty("url1"));
			}
		
		@Test
		public void Movelist() throws InterruptedException{
	
			//constructor from Page object
			DualListBox P = new DualListBox(driver);

			P.search().sendKeys("bootstrap");
			String text = P.item().getText();
			Log.info(text);
			Listeners.test.log(LogStatus.INFO,text);
			P.item().click();
			P.arrow().click();			
		    int s = P.item2().size();
		    
		    //defining lists
		    ArrayList<String> b = new ArrayList<String>();
		    
		    //Storing values to a List
			 for(int j=0;j<s;j++) {
			 b.add(P.item2().get(j).getText());
			 }
			 
			 StringBuilder sb = new StringBuilder(); 
	            for (String n : b)
	            {
	                sb.append(n);
	                sb.append("\t");
	            }
			 Log.info("--- Search Results in Row ---" );
			 Listeners.test.log(LogStatus.INFO,"--- Search Results in Row ---" );
			 Log.info(b);
			 Listeners.test.log(LogStatus.INFO,sb.toString());
			 
			 //Listeners.test.log(LogStatus.INFO,b);
			 
			  //Checking if the results are correct irrespective of the case
			  Assert.assertTrue(b.contains(text));
			  
		

		}
		@AfterMethod
		public void teardown(){
	    	 driver.close();
		}
 }
			 
		
		
		
	