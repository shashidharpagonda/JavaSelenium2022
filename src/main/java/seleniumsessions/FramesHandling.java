package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		Thread.sleep(4000);
		
		By image=By.xpath("//img[@title='vehicle-registration-forms-and-templates']");
		
		ElementUtil eu=new ElementUtil(driver);
		
		eu.doClick(image);
		
		driver.switchTo().frame("frame-one748593425");
		
		By vehicleYear= By.name("RESULT_TextField-2");
		By vehicleMake= By.name("RESULT_TextField-3");
		By vehicleModel=By.name("RESULT_TextField-4");
		
		By color= By.id("RESULT_TextField-5");
		By meilage=By.id("RESULT_TextField-6");
		
		By VIN=By.id("RESULT_TextField-7");
		By name=By.id("RESULT_TextField-8");
		By address=By.id("RESULT_TextField-9");
		
		By city=By.id("RESULT_TextField-11");
		By state=By.id("RESULT_RadioButton-12");
		
		By zip=By.id("RESULT_TextField-13");
		By phone=By.id("RESULT_TextField-14");
		By email=By.id("RESULT_TextField-15");
		
		By submitButton=By.id("FSsubmit");
		
		eu.doSendKeys(vehicleYear, "2022");
		eu.doSendKeys(vehicleMake, "Audi");
		eu.doSendKeys(vehicleModel, "XZ");
		
		eu.doSendKeys(color, "Blue");
		eu.doSendKeys(meilage, "20");
		
		eu.doSendKeys(VIN, "ABCD20XYZ");
		eu.doSendKeys(name, "Audi-Hybrid");
		eu.doSendKeys(address, "DC");
		eu.doSendKeys(city, "NJY");
		
		eu.doSelectDropDownByVisibleText(state, "Hawaii");
		
		eu.doSendKeys(zip, "202202");
		eu.doSendKeys(phone, "202-202-202");
		eu.doSendKeys(email, "shas@202202.com");
		
		eu.doClick(submitButton);
		
	}
}
