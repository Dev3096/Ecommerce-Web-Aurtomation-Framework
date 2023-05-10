package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class HomePagePOM extends AbstractComponent{
	WebDriver driver;
	public HomePagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div/h2")
	WebElement homeTitle;
	
	@FindBy(xpath="//*[@id=\"nav\"]/ol/li[1]/a")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div[2]/div/a")
	WebElement Account;
	
	@FindBy(xpath="//*[@id=\"header-account\"]/div/ul/li[1]/a")
	WebElement myAccount;
	
	public String getHomeTitle() {
		return homeTitle.getText();
	}
	
	public void clickMobile() {
		mobile.click();
		
	}
	
	
	public void clickAccount() {
		Account.click();
	}
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
}
