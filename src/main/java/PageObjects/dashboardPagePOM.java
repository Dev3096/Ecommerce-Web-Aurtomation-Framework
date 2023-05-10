package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class dashboardPagePOM extends AbstractComponent{
	//int count = 3;
	WebDriver driver;
	public dashboardPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
	WebElement myWishList;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")
	WebElement myOrders;
	
	@FindBy(linkText="VIEW ORDER")
	WebElement viewOrder;
	
	public void clickWishList() {
		myWishList.click();
		
	}
	
	public void clickMyOrders() {
		myOrders.click();
	}
	
	public void clickViewOrder() {
		viewOrder.click();
	}
	
	
	
	
	
}
