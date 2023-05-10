package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class tvPagePOM extends AbstractComponent{
	WebDriver driver;
	public tvPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
	WebElement lgLCD;
	
	@FindBy(xpath="//*[@id=\"wishlist-view-form\"]/div/div/button[1]")
	WebElement share;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div[2]/button")
	WebElement shareList;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")
	WebElement verifyShare;
	
	public void addToWishList() {
		lgLCD.click();
		share.click();
	}
	
	public String shareWishlist() throws InterruptedException {
		email.sendKeys("abc@gmail.com");
		shareList.click();
		return verifyShare.getText();
	}
	
	
	
	
	
}
