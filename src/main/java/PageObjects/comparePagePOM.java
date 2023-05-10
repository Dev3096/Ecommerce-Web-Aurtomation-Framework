package PageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class comparePagePOM extends AbstractComponent{
	WebDriver driver;
	public comparePagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div[1]/h1")
	WebElement compareTitle;
	
	@FindBy(xpath="//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2/a")
	WebElement item1;
	
	@FindBy(xpath="//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")
	WebElement item2;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div[2]/button")
	WebElement close;
	
	public String commparePageTitle() {
		return compareTitle.getText();
		}
	
	public List<String> itemsOnCompareTab() {
		List<String> myList = new ArrayList<>();
		myList.add(item1.getText());
		myList.add(item2.getText());
		return myList;
	}
	
	public void closeCompareTab() {
		close.click();
		for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		}
	}
}
