package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\F DriveData\\AutomationLearning\\Shashi_Auto\\mvnselenium2022\\driver\\chromedriver.exe");		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		
		
		String title= driver.getTitle();
		System.out.println("title:"+title);
		
		if(title.equals("Google"))
			System.out.println("Correct title");
		else
			System.out.println("Unexpected");
		
		
		
		String url=driver.getCurrentUrl();
		System.out.println("url:"+url);
		
		driver.quit();
	}
}
