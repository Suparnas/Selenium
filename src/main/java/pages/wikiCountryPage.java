package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wikiCountryPage {

	WebDriver driver;
	By eg = By.xpath("//test");

	
	
	
	public wikiCountryPage(WebDriver driver) {
		this.driver =driver;
	}
	
	
	public void geteg() {
		driver.findElement(eg);
	}
	
	
}
