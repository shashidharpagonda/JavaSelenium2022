package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AsWebTable {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/");
		
		By popup= By.xpath("//button[@id='wzrk-cancel']");
		By cricinfoImg= By.xpath("//img[@alt='ESPNcricinfo']");
		By stats= By.xpath("//a[normalize-space()='Series']");
		By IPL2022 = By.xpath("//span[@class='ds-grow'][normalize-space()='IPL 2022']");
		By table   = By.xpath("//div[@class='ds-grow']//a/span[text()='Table']");
		
		Thread.sleep(30000);		
		driver.findElement(popup).click();
		Thread.sleep(5000);		
		driver.findElement(cricinfoImg).click();
		Thread.sleep(5000);
		
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(stats)).perform();
		Thread.sleep(2000);
		driver.findElement(IPL2022).click();
		Thread.sleep(15000);
		driver.findElement(table).click();
		Thread.sleep(5000);
		
		String team= "Gujarat Titans";
		By teamDetails=By.xpath("//a//span[text()='"+team+"']/ancestor::td/following-sibling::td[not(contains(@class, 'ds-cursor'))]");
		
		List<WebElement> teamInfo =driver.findElements(teamDetails);
		
		List<String> teamdata=new ArrayList<String>();
		for(WebElement e: teamInfo)
		{
			teamdata.add(e.getText());
		}
		System.out.println(teamdata);
		
		
		
		
	}
}
