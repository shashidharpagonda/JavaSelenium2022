package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassMethods {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		Thread.sleep(3000);
		
		By name=By.id("Form_submitForm_Country");
		
		Select select=new Select(driver.findElement(name));
		select.selectByValue("India");
		
		List<WebElement> options = select.getOptions();
		for(WebElement e: options)
		{
			System.out.println(e.getText());
		}
		
	}
}
