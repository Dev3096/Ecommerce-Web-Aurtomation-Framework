package TechPanda;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.DetailsPagePOM;
import PageObjects.HomePagePOM;
import PageObjects.MobilePagePOM;
import PageObjects.cartPagePOM;
import TestComponents.BaseTest;

public class CartPage extends BaseTest{
	int scc = 0;
	@Test(groups= {"inCart"},dataProvider="getData")
	public void checkquantity(HashMap<String, String> map) throws InterruptedException, IOException {
		home.clickMobile();
		mobilePage.clickXperia();
		
		// add item to cart
		detail.clickAddToCart();		
		//enter quantity and click on update
		if (map.get("quantity") == "1000") {
			cart.enterQTY(map.get("quantity"));
			
			//verify the error message
			String error = "Some of the products cannot be ordered in requested quantity.";
			Thread.sleep(2000);
			Assert.assertEquals(error, cart.getQtyError());
		} else {
			cart.enterQTY(map.get("quantity"));
		}
		//String qty = "1000";
		
		
		// click on empty cart link 
		cart.clickEmptycart();
		String empty = "SHOPPING CART IS EMPTY";
		Thread.sleep(2000);
		Assert.assertEquals(empty, cart.emptyCartMessageString());
	}
	
	@DataProvider
	public Object[] getData() {
		HashMap<String, String> map = new HashMap();
		HashMap<String,String> map2 = new HashMap();
		map.put("quantity", "1000");
		map2.put("quantity", "1000");
		return new Object[] {map,map2};
	}
	
	
}
