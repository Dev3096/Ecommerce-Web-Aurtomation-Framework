package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class wishlistPagePOM extends AbstractComponent{
	//int count = 3;
	WebDriver driver;
	public wishlistPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cart-cell']//button[@title='Add to Cart']")
	WebElement addToCart;
	
	public void addElementTOCart() {
		addToCart.click();
	}
	
	
	
	
	
	
}
