package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ordersPagePOM extends AbstractComponent{
	//int count = 3;
	WebDriver driver;
	public ordersPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1")
	//*[@id="top"]/body/div/div/div[2]/div/div/div[1]/h1
	WebElement orderConfirm;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a")
	WebElement orderNo;
	
	public String confirmOrder() {
		return orderConfirm.getText();
	}
	
	public String getOrderNumber() {
		return orderNo.getText();
	}
	
	
}
