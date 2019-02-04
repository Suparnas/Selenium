package test;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
//Description: Class to test sorting in ascending/descending order
//******************************************************************

public class SortingTest extends Base{
		public static Logger Log = LogManager.getLogger(SortingTest.class.getName());
	    
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			driver.get(prop.getProperty("url3"));
		}
		@Test
		public void Sorting() {
			
			//constructor from Page Object
			tablepage P = new tablepage(driver);

			//page numbers
			int c =  P.page().size();
			
			//defining lists
		    ArrayList<String> b = new ArrayList<String>();
		    ArrayList<String> b1 = new ArrayList<String>();
		    ArrayList<String> b2 = new ArrayList<String>();
		    //Storing values to a List
		    for (int i=1;i<=c;i++) {
		       int s = P.name().size();
			   for(int j=0;j<s;j++) {
			   b.add(P.name().get(j).getText());
			  }
			  if(i<c) {
			     P.page().get(i).click();
		        }
			}
		    

		    StringBuilder sb = new StringBuilder(); 
		    for (String s : b)
		    {
		        sb.append(s);
		        sb.append("\t");
		    }

		    Log.info("---UnSorted List---" + c);
		    Listeners.test.log(LogStatus.INFO,"---UnSorted List---" + c + sb.toString());
		    Log.info(b);
		    Listeners.test.log(LogStatus.INFO,sb.toString());
		    
		    
		    //Sorting the list
		    Collections.sort(b);
		    Log.info("---Sorted List---");
		    Listeners.test.log(LogStatus.INFO,"---Sorted List---");
		    Log.info(b);
		    
		    
		    //Going back to first page
		    P.page().get(0).click();
		    
		    //Click on header to sort
		    P.position().click();
		    
		  //Storing values to a List
		    for (int i=1;i<=c;i++) {
		      int s = P.name().size();
			  for(int j=0;j<s;j++) {
				b1.add(P.name().get(j).getText());
			  }
			  if(i<c) {
				P.page().get(i).click();
		       }
			}
		    
		    
		    
		    
		    StringBuilder sb1 = new StringBuilder(); 
		    for (String s1 : b1)
		    {
		        sb1.append(s1);
		        sb1.append("\t");
		    }
		    Log.info(b1);
		    Log.info("---After Sorted List---");
		    Listeners.test.log(LogStatus.INFO,"---After Sorted List---");
		    Listeners.test.log(LogStatus.INFO, sb1.toString());
		    
		    //Checking if the sorting is correct
		    AssertJUnit.assertEquals(b, b1);
		    
		    //reversing the list
		    Collections.reverse(b);
		    Log.info("---Reverse Sorted List---");
		    Listeners.test.log(LogStatus.INFO,"---Reverse Sorted List---");
		    Log.info(b);
		  //  Listeners.test.log(LogStatus.INFO,b);
		    
		    //Going back to first page
		    P.page().get(0).click();
		    
		    //Click on header to reverse sort
		   
		    P.position().click();
		    
		   //Storing values to a List
		    for (int i=1;i<=c;i++) {
		      int s = P.name().size();
			  for(int j=0;j<s;j++) {
				b2.add(P.name().get(j).getText());
			  }
			  if(i<c) {
				P.page().get(i).click();
		       }
			}
		    
		    StringBuilder sb2 = new StringBuilder(); 
		    for (String s2 : b2)
		    {
		        sb2.append(s2);
		        sb2.append("\t");
		    }
		    
		    Log.info("---After Reverse Sorted List---");
		    Listeners.test.log(LogStatus.INFO,"---After Reverse Sorted List---");
		    Log.info(b2);
		    Listeners.test.log(LogStatus.INFO, sb2.toString());
		    
		    
		    
		    
		   // Listeners.test.log(LogStatus.INFO, b2);
		    
		    //Checking if the sorting is correct
		    Assert.assertEquals(b2, b);
		    Assert.assertEquals(b2, b1);//checking a failure
		    
		
		}
		 @AfterMethod
			public void teardown(){
		    	 driver.close();
			}
		
	}