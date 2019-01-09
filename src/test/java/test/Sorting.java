package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.tablepage;
import utilities.Base;

//******************************************************************
//Author: Suparna Soman
//Description: Class to test sorting in ascending/descending order
//******************************************************************

public class Sorting extends Base{
		public static Logger Log = LogManager.getLogger(Sorting.class.getName());
	    
		@BeforeMethod
		public void initialize() throws IOException {
			driver = initializeDriver();
			Log.info("Driver is initialized");
			driver.get(prop.getProperty("url3"));
		}
		@Test
		public void SortingTest () {
			
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
		    Log.info("---UnSorted List---" + c);
		    Log.info(b);
		    
		    //Sorting the list
		    Collections.sort(b);
		    Log.info("---Sorted List---");
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
		    
		    Log.info("---After Sorted List---");
		    Log.info(b1);
		    
		    //Checking if the sorting is correct
		    Assert.assertEquals(b, b1);
		    
		    //reversing the list
		    Collections.reverse(b);
		    Log.info("---Reverse Sorted List---");
		    Log.info(b);
		    
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
		    Log.info("---After Reverse Sorted List---");
		    Log.info(b2);
		    
		    //Checking if the sorting is correct
		    Assert.assertEquals(b2, b);
		    
		driver.quit();
		}
		
		
	}