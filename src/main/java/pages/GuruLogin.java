package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuruLogin {

	public WebDriver driver;
	By uid = By.xpath("//input[@name='uid']");
	By password  = By.xpath("//input[@name='password']");
	By login  = By.xpath("//input[@type='submit']");
	By logged = By.xpath("//marquee[@class='heading3']");
	By logout = By.xpath("//a[@href='Logout.php']");
	
	public GuruLogin (WebDriver driver) {
		this.driver = driver;
	}

	public WebElement uid() {
		return driver.findElement(uid);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	} 
	
	public WebElement logged() {
		return driver.findElement(logged);
	} 
	public WebElement logout() {
		return driver.findElement(logout);
	} 
}
