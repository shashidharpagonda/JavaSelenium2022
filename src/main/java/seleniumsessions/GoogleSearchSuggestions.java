package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSuggestions {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		Thread.sleep(4000);
		
		By suggList=By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']/span");
		String valueToClick="naveen automationlabs java";
		ClickonElementFromSection(suggList, valueToClick);
		
		
		//Assignment
		//driver.findElement(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']/span[text()="naveen "]/b[contains(text(),'automationlabs')]/following-sibling::b[contains(text(), ' java')]")).click();

		
	}
	
	public static void ClickonElementFromSection(By locator,String value)
	{
		List<WebElement> suggList = driver.findElements(locator);
		
		for(WebElement e: suggList)
		{	String text= e.getText();
			System.out.println("===="+text+"====");
			if(text.contains(value))
			{
				e.click();
				break;
			}
		}
	}
}
