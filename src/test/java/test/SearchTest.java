package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.tablepage;
import utilities.Base;
import utilities.Listeners;

//******************************************************************
//Author: Suparna Soman
//Description: Class to test Search
//******************************************************************

public class SearchTest extends Base
 {
	public static Logger Log = LogManager.getLogger(SearchTest.class.getName());
    
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url2"));
	}
		
	
		@Test
		public void Search() throws InterruptedException{
				
			
			//constructor from Page object
			tablepage P = new tablepage(driver);
			
			//Entering the search
			P.search().sendKeys(prop.getProperty("search"));
			
			//page numbers
			int c =  P.page().size();
		    int s = P.rowvalue().size();
		    //defining Array
		    String[][] p = new String [s][s];
		    
		    //Storing values to a List
		    for (int i=1;i<=c;i++) {
		       
			   for(int j=0;j<s;j++) {
			  p[i][j]= P.rowvalue().get(j).getText();
			  Listeners.test.log(LogStatus.INFO,"--- Results shown Search Results in Row " + (j+1) + "---");
			  Listeners.test.log(LogStatus.INFO,"Results shown" + p[i][j]);
			  Log.info(p[i][j]);
			  Listeners.test.log(LogStatus.INFO, p[i][j]);
			  //Checking if the results are correct irrespective of the case
			    Assert.assertTrue(p[i][j].toLowerCase().contains(prop.getProperty("search").toLowerCase()));
			  if(i<c) {
			     P.page().get(i).click();
		        }}
	
			 
		}}
		
		 @AfterMethod
			public void teardown(){
		    	 driver.close();
			}
	}