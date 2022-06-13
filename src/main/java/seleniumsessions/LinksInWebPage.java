package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksInWebPage {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");

		Thread.sleep(3000);

		List<WebElement> links = driver.findElements(By.xpath("//a"));

		System.out.println("++++++++++++++++++++++++++++++++");
		for (WebElement e : links) {
			try {
				if (e.getAttribute("href").contains("https")) {
					System.out.println(e.getAttribute("href"));
				}
			} catch (NullPointerException e1) {
				System.out.println("NPE");
			}
		}

		System.out.println("+++++++++++++ Invalid links +++++++++++++++++++");
		
		  for(WebElement e: links) 
		  { 
			  try {
				  	if(e.getAttribute("href").indexOf("http")==-1) 
				  	{
				  		System.out.println(e.getAttribute("href")); 
				  	}
				  } 
			  catch(NullPointerException e1) { System.out.println("NPE"); } }
		 
		/*
		 * for(WebElement e: links) { System.out.println(e.getAttribute("href")); }
		 */
	}
}
