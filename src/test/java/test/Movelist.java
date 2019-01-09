package test;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DualListBox;
import utilities.Base;

//*******************************************************************
//Author: Suparna Soman
//*******************************************************************

public class Movelist extends Base
 {
			public static Logger Log = LogManager.getLogger(Movelist.class.getName());
		    
			@BeforeTest
			public void initialize() throws IOException {
				driver = initializeDriver();
				Log.info("Driver is initialized");
				driver.get(prop.getProperty("url1"));
			}
		
		@Test
		public void cTest() throws InterruptedException{
	
			//constructor from Page object
			DualListBox P = new DualListBox(driver);

			P.search().sendKeys("bootstrap");
			String text = P.item().getText();
			Log.info(text);
			P.item().click();
			P.arrow().click();			
		    int s = P.item2().size();
		    
		    //defining lists
		    ArrayList<String> b = new ArrayList<String>();
		    
		    //Storing values to a List
			 for(int j=0;j<s;j++) {
			 b.add(P.item2().get(j).getText());
			 }
			 Log.info("--- Search Results in Row ---" );
			 Log.info(b);
			 
			  //Checking if the results are correct irrespective of the case
			  Assert.assertTrue(b.contains(text));
			  
		driver.quit();
 }
		}
			 
		
		
		
	