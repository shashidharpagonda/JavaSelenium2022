package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	
	// driver will be local to this class itself
	private WebDriver driver;
	
	/* Constructor: 
	 * 				
	 * 				Here there is no WebDriver driver = new ChromeDriver();
	 * 				So, when you create an object of ElementUtil class in page classes,
	 * 				driver will get the value whether it is ChromeDriver/FirefoxDriver etc
	 * 				to access all the methods of this class.
	 */
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	//This method will be used only when OS has String locators
	public By getBy(String locatorType, String locatorValue)
	{
		By locator=null;
		
		switch(locatorType.toLowerCase())
		{
			case "id":
				locator=By.id(locatorValue);
				break;
			
			case "name":
				locator=By.name(locatorValue);
				break;
			
			case "classname":
				locator=By.className(locatorValue);
				break;
				
			case "tagname":
				locator=By.tagName(locatorValue);
				break;
				
			case "linktext":
				locator=By.linkText(locatorValue);
				break;
				
			case "partiallinktext":
				locator=By.partialLinkText(locatorValue);
			
			case "xpath":
				locator=By.xpath(locatorValue);
				break;
				
			case "css":
				locator=By.cssSelector(locatorValue);
				break;
				
			default:
				System.out.println("Please pass the right locator");
				break;
		}
		return locator;
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public String doGetElementText(By locator)
	{
		return getElement(locator).getText();
	}
	
	public String doGetAttributeValue(By locator, String attributeName) 
	{
		return getElement(locator).getAttribute(attributeName);
	}

	public boolean doIsDisplayed(By locator) 
	{
		return getElement(locator).isDisplayed();
	}
	
	public int getElementsCount(By locator) 
	{
		return getElements(locator).size();
	}
	
	
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	
	public void ClickonElementFromSection(By locator,String value)
	{
		List<WebElement> suggList = getElements(locator);
		
		for(WebElement e: suggList)
		{	String text= e.getText();
			System.out.println("===="+text+"====");
			if(text.contains(value))
			{
				e.click();
				break;
			}
		}
	}
	
	public int getElementsListCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementsTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

	public void printAllElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println("===============" + text + "===============");
		}

	}

	
	// *****************************DropDownUtils************************//

		public void doSelectDropDownByIndex(By locator, int index) {
			Select select = new Select(getElement(locator));
			select.selectByIndex(index);
		}

		public void doSelectDropDownByVisibleText(By locator, String visibleText) {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(visibleText);
		}

		public void doSelectDropDownByValue(By locator, String value) {
			Select select = new Select(getElement(locator));
			select.selectByValue(value);
		}

		public int getSelectDropDownValueCount(By locator) {
			return getElements(locator).size();
		}

		public List<String> getSelectDropDownValuesList(By locator) {
			List<String> valuesList = new ArrayList<String>();
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();

			for (WebElement e : optionsList) {
				String text = e.getText();
				valuesList.add(text);
			}
			return valuesList;
		}

		public void selectValueFromSelectDropDown(By locator, String value) {
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();

			for (WebElement e : optionsList) {
				String text = e.getText();
				if (text.contains(value)) {
					e.click();
					break;
				}
			}
		}

		public void printSelectDropDownValues(By locator) {
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();
			System.out.println(optionsList.size());

			for (WebElement e : optionsList) {
				String text = e.getText();
				System.out.println("================" + text + "==============");
			}
		}
		
		public void selectValueFromDropDown(By locator, String value) {
			List<WebElement> countryOptions = getElements(locator);
			System.out.println(countryOptions.size());
			for (int i = 0; i < countryOptions.size(); i++) {
				String text = countryOptions.get(i).getText();
				System.out.println("============" + text + "============");
				if (text.contains(value)) {
					countryOptions.get(i).click();
					break;
				}
			}
		}
	
}
