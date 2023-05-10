package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class DetailsPagePOM extends AbstractComponent{
	WebDriver driver;
	public DetailsPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='product-price-1']")
	WebElement xperiaPrice;
	
	@FindBy(xpath="//*[@id=\"product_addtocart_form\"]/div[4]/div/div/div[2]/button/span/span")
	WebElement addtoCart;
	
	public String getxperiaPrice() {
		return xperiaPrice.getText();
	}
	
	public void clickAddToCart() {
		addtoCart.click();
	}
	
	
}
