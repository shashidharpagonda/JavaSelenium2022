package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Assignment
public class AsFormByLocator {

	public static void main(String[] args) {
		
		BrowserUtil bUtil=new BrowserUtil();
		
		//Here driver is defined. It is req to pass as parm to ElementUtil object.
		WebDriver driver = bUtil.init_driver("chrome");
		
		bUtil.navigateUrl("https://demo.opencart.com/index.php?route=account/register");
		
		By firstName=By.id("input-firstname");
		By lastName=By.id("input-lastname");
		By email=By.id("input-email");
		By telephone= By.id("input-telephone");
		
		By firstNamexpath=By.xpath("//input[@id='input-firstname']");
		
		ElementUtil ele=new ElementUtil(driver);
		ele.doSendKeys(firstNamexpath, "Shash");
		ele.doSendKeys(lastName, "Pags");
		ele.doSendKeys(email, "shashitest3@gmail.com");
		ele.doSendKeys(telephone, "9876543210");
		ele.doSendKeys(firstName, "Recheck");
		
	}
}
