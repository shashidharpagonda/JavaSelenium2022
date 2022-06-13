package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSuggestionList {
	static WebDriver driver;
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	
	driver.get("http://automationpractice.com/index.php");
	Thread.sleep(5000);
	
	driver.findElement(By.id("search_query_top")).sendKeys("dress");
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Evening Dresses > Printed')]")).click();
	
}
}
