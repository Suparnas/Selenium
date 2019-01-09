package utilities;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
//*********************************************************************************************************
//Author: Suparna Soman
//Description: PropertyManager class reads global configurations and use them during test execution.
//*********************************************************************************************************
public class PropertyManager {
 
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String FilePath = ("./src/main/resources/data.properties");
    private static String url;
    private static String uid;
    private static String pass;
    private static String title;
    private static String error;
 
    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
 
    //Get all data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read data.properties file
        try {
            prop.load(new FileInputStream(FilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("data.properties"));
        } catch (IOException e) {
            System.out.println("Data properties file cannot be found");
        }
 
        //Get properties from data.properties
        url = prop.getProperty("url");
        uid = prop.getProperty("userid");
        pass = prop.getProperty("password");
        title = prop.getProperty("title");
        error = prop.getProperty("error");
    }
 
    public String getURL () {
	      return url;
	    }
	 
	    public String getuid () {
	        return uid;
	    }
	 
	    public String getpass () {
	        return pass;
	    }
	    public String gettitle () {
	        return title;
	    }
	    public String geterror () {
	        return error;
	    }
	   
}