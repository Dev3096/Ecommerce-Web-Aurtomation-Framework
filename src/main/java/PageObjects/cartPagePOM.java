package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class cartPagePOM extends AbstractComponent{
	WebDriver driver;
	public cartPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")
	WebElement qty;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span")
	WebElement update;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/ul/li/ul/li/span")
	WebElement qtyError;
	
	@FindBy(xpath="//*[@id=\"empty_cart_button\"]")
	WebElement emptyCart;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1")
	WebElement emptyCartMessage;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")
	WebElement proceedToCheckOut;
	
	public void enterQTY(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		update.click();
	}
	
	public String getQtyError() {
		return qtyError.getText();
	}
	
	public void clickEmptycart() {
		emptyCart.click();
	}
	
	public String emptyCartMessageString() {
		return emptyCartMessage.getText();
	}
	
	public void clickProceedToCheckOut() {
		proceedToCheckOut.click();
	}
	
	
}
