package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		String name="John.Smith";
		By checkbox =By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input");
		
		driver.findElement(checkbox).click();
		
		/*
		 * By
		 * userdata=By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td");
		 * List<WebElement> userinfo =driver.findElements(userdata);
		 * 
		 * for(WebElement e: userinfo) { System.out.println(e.getText()); }
		 */
		
		System.out.println(getUserData("John.Smith"));
	}
	
	public static List<String> getUserData(String name)
	{
		By userdata=By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td");
		List<WebElement> userinfo =driver.findElements(userdata);
		List<String> colList=new ArrayList<String>();
		
		for(WebElement e: userinfo)
		{
		colList.add(e.getText());
		}
		
		return colList;
	}
}
