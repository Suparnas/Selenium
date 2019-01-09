package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tablepage {

	
	
   public WebDriver driver;
	By name = By.xpath("//tbody//td[2]");
	By page  = By.xpath("//span//a[starts-with(@class,'paginate_button')]");
    By position = By.xpath("//tr//th[starts-with(@class,'sorting')][2]");;
	By password = By.xpath("//input[@type='password']");
	By search = By.xpath("//input[@type='search']");
	By rowvalue = By.xpath("//tr[contains(@class,'odd') or contains(@class,'even') ]");
	
	public tablepage (WebDriver driver) {
		this.driver = driver;
	}
	public List<WebElement> name() {
		return driver.findElements(name);
	}
	public List<WebElement> page() {
		return driver.findElements(page);
	}
	public WebElement position() {
		return driver.findElement(position);
	} 
	public WebElement password() {
		return driver.findElement(password);
	} 
	public WebElement search() {
		return driver.findElement(search);
	} 
	public List<WebElement> rowvalue() {
		return driver.findElements(rowvalue);
	}
	
}
