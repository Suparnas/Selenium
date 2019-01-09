package pages;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

public class DualListBox {

	   public WebDriver driver;
		By name = By.xpath("//tbody//td[2]");
		By page  = By.xpath("//span//a[starts-with(@class,'paginate_button')]");
	    By position = By.xpath("//tr//th[starts-with(@class,'sorting')][2]");;
		By search = By.xpath("//input[@name='SearchDualList']");
		By item = By.xpath("//div[@class='well text-right']//li[@class='list-group-item'][1]");
		By item2 = By.xpath("//div[@class='dual-list list-right col-md-5']//li[starts-with(@class,'list-group-item')]");
		By arrow = By.xpath("//span[@class='glyphicon glyphicon-chevron-right']");

		public DualListBox (WebDriver driver) {
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
		public WebElement search() {
			return driver.findElement(search);
		} 
		public WebElement item() {
			return driver.findElement(item);
		}
		public List<WebElement> item2() {
			return driver.findElements(item2);
		}
		public WebElement arrow() {
			return driver.findElement(arrow);
		} 
		
	}
