package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil implements Util{

	WebDriver driver;
	
	public WebDriver init_driver(String browserName)
	{
		System.out.println("Browser Name is:"+browserName);
		
		if(browserName.equalsIgnoreCase(CHROME_BROWSER))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase(FIREFOX_BROWSER))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase(SAFARI_BROWSER))
		{
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}
		else
		{
			System.out.println("Please pass the valid browser");
		}
		return driver;
	}
	
	@Override
	public void navigateUrl(String url) {
		if(url==null)
		{
			return;
		}
		if(url.isEmpty())
		{
			return;
		}
		if(url.indexOf("http")==-1 || url.indexOf("https")==-1)
		{
			System.out.println("Please pass the right url, http(s) is missing");
			return;
		}
		driver.get(url);
	}
	
	@Override
	public void navigateUrl(URL url)
	{
		driver.navigate().to(url);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void quitBrowser() {
		driver.quit();
	}

}
