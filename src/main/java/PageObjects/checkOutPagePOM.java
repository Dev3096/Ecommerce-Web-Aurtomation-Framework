package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class checkOutPagePOM extends AbstractComponent{
	//int count = 3;
	WebDriver driver;
	public checkOutPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="billing:firstname")
	WebElement FirstName;
	
	
	@FindBy(id="billing:lastname")
	WebElement LastName;
	
	@FindBy(id="billing:street1")
	WebElement address;
	
	@FindBy(id="billing:city")
	WebElement city;
	
	@FindBy(id="billing:postcode")
	WebElement zip;
	
	@FindBy(id="billing:country_id")
	WebElement country;
	
	@FindBy(id="billing:telephone")
	WebElement telephone;
	
	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/button")
	WebElement continueButton;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement continueAfterShipping;
	
	@FindBy(xpath="//*[@id=\"checkout-shipping-method-load\"]/dl/dd/ul/li/label/span")
	WebElement shippingPrice;
	
	@FindBy(id="p_method_checkmo")
	WebElement check;
	
	@FindBy(xpath="//*[@id=\"review-buttons-container\"]/button")
	WebElement placeOrder;
	
	@FindBy(id="billing:region_id")
	WebElement state;
	
	@FindBy(xpath="//*[@id=\"payment-buttons-container\"]/button")
	WebElement paymentContinue;
	
	public void enterBillingInfo() {
		FirstName.sendKeys("jane");
		LastName.sendKeys("Doe");
		address.sendKeys("abc");
		city.sendKeys("New York");
		zip.sendKeys("542896");
		Select se = new Select(country);
		se.selectByValue("US");
		Select se2 = new Select(state);
		se2.selectByValue("1");
		telephone.sendKeys("12345678");
		
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public String getShippingPrice() {
		return shippingPrice.getText();
	}
	
	public void clickContinueAfterShipping() {
		continueAfterShipping.click();
	}
	
	public void clickCheck() {
		check.click();
	}
	
	public void clickContinueAfterPayment() {
		paymentContinue.click();
	}
	
	public void clickPlaceOrder() {
		placeOrder.click();
	}
	
	
	

	
	
}
