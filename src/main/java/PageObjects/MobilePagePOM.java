package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class MobilePagePOM extends AbstractComponent{
	WebDriver driver;
	public MobilePagePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[1]/h1")
	WebElement mobileTitle;
	
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sort;
	
	@FindBy(css=".product-name")
	List<WebElement> prodts;
	
	@FindBy(xpath="//*[@id='product-price-1']")
	WebElement xperiaPrice;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")
	WebElement xperia;
	
	@FindBy(css=".link-compare")
	List<WebElement> compareLinks;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button/span/span")
	WebElement compare;
	
	public String getMobilePageTitle() {
		return mobileTitle.getText();
	}
	
	public void selectSortByName() throws InterruptedException {
		Select se = new Select(sort);
		se.selectByIndex(1);
		Thread.sleep(2000);
	}
	
	public List<String> getProductsName() {
		List<String> prodName = new ArrayList<>();
		for (int i = 0; i < prodts.size(); i++) {
			if (i == 2) break;
			prodName.add(prodts.get(i).getText());
		}
		return prodName;
	}
	
	public String getxperiaPrice() {
		return xperiaPrice.getText();
	}
	
	public void clickXperia() {
		xperia.click();
		
	}
	
	public comparePagePOM addToCompare() throws InterruptedException {
		for (int i = 0; i< compareLinks.size(); i++) {
			if (i == 2) break;
			compareLinks.get(i).click();
		}
		compare.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		comparePagePOM compareProducts = new comparePagePOM(driver);
		Thread.sleep(2000);
		return compareProducts;
	}
	
	
}
