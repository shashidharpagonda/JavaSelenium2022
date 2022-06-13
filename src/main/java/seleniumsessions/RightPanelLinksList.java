package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightPanelLinksList {
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		List<WebElement> rightPanel= driver.findElements(By.xpath("//aside[@id='column-right']//a"));
		
		for(WebElement e: rightPanel)
		{
			if(e.getText().contains("Register"))
			{
				e.click();
			}
		}
		
	}
}
