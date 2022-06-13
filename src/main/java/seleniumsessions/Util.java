package seleniumsessions;

import java.net.URL;

public interface Util {

	String CHROME_BROWSER="Chrome";
	String FIREFOX_BROWSER="Firefox";
	String SAFARI_BROWSER="Safari";
	
	public void navigateUrl(String url);
	
	public String getPageTitle();
	
	public String getPageUrl();
	
	public String getPageSource();
	
	public void closeBrowser();
	
	public void quitBrowser();

	public void navigateUrl(URL url);

}
