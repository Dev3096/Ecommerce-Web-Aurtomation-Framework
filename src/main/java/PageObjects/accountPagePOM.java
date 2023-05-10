package PageObjects;

import org.openqa.selenium.WebDriver;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class accountPagePOM extends AbstractComponent{
	WebDriver driver;
	static int count;
	public accountPagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div/div[1]/div[2]/a")
	WebElement createAccount;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="email")
	WebElement enterEmail;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="pass")
	WebElement enterPassword;
	
	@FindBy(id="confirmation")
	WebElement confirm;
	
	@FindBy(id="send2")
	WebElement userLogin;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div[2]/button")
	WebElement register;
	
	@FindBy(xpath="//*[@id='nav']/ol/li[2]")
	WebElement tvLink;
	
	public void clickCreatAccount() {
		createAccount.click();
	}
	
	public void userDetails() {
		Random rand = new Random();
		count = rand.nextInt(1000000);
		firstName.sendKeys("Jane" + count);
		lastName.sendKeys("Doe");
		email.sendKeys("jane" + count + "doe@gmail.com");
		password.sendKeys("12345678");
		confirm.sendKeys("12345678");
		register.click();
		
	}
	
	public void login() {
		enterEmail.sendKeys("jane" + count + "doe@gmail.com");
		//enterEmail.sendKeys("jane9doe@gmail.com");
		enterPassword.sendKeys("12345678");
		userLogin.click();
		
	}
	
	public tvPagePOM goToTV() {
		tvLink.click();
		tvPagePOM tv = new tvPagePOM(driver);
		return tv;
	}
	
	
	
	
	
	
}
