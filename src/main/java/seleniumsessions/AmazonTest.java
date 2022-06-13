package seleniumsessions;

//Selenium03
public class AmazonTest {

	public static void main(String[] args) {
		 
		BrowserUtil bu=new BrowserUtil();
		bu.init_driver("chrome");
		bu.navigateUrl("https://www.amazon.in");
		
		String title=bu.getPageTitle();
		if(title.contains("amazon"))
			System.out.println("Correct title");
		else
			System.out.println("Incorrect title");
		
		System.out.println(bu.getPageSource().contains("https://www.amazon.in"));
		
		bu.closeBrowser();
	}
}
