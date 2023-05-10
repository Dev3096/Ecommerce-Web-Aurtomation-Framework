package PageObjects;

import org.openqa.selenium.WebDriver;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class prevOrdersPOM extends AbstractComponent{
	WebDriver driver;
	static int count;
	public prevOrdersPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/h1")
	WebElement verifyOrder;
	
	@FindBy(linkText="Print Order")
	WebElement printOrder;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]")
	WebElement save;
	
	@FindBy(xpath="//*[@id=\"destinationSelect\"]//print-preview-settings-section/div/select")
	WebElement selectSave;
	
	public String getOrderNumberVerified() {
		return verifyOrder.getText();
	}
	
	public void clickPrintOrder() {
		printOrder.click();
	}
	
	public void printOrder() throws InterruptedException {
		Thread.sleep(2000);
		Select se = new Select(selectSave);
		se.selectByVisibleText("Save as PDF");
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
		save.click();
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	}
	
	
}
