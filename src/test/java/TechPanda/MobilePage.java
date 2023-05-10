package TechPanda;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DetailsPagePOM;
import PageObjects.HomePagePOM;
import PageObjects.MobilePagePOM;
import PageObjects.comparePagePOM;
import TestComponents.BaseTest;

public class MobilePage extends BaseTest{
	int scc = 0;
	@Test(groups= {"sortmobile"})
	public void checkSorted() throws InterruptedException, IOException {
		// assert the home page title
		String homePage = "THIS IS DEMO SITE";
		String mobileTitle = "MOBILE";
		Assert.assertTrue(home.getHomeTitle().contains(homePage));
		
		// click on 'MOBILE' menu
		//MobilePagePOM mobilePage = home.clickMobile();
		home.clickMobile();
		// Verify the title of the mobile page
		Assert.assertEquals(mobileTitle, mobilePage.getMobilePageTitle());
		
		// Select sortBy as name
		mobilePage.selectSortByName();
		
		//check if the name are sorted or not using screenshot
		mobilePage.screenShot("sort", driver);
		
	}
	
	@Test(groups= {"mobile"})
	public void verifyPrice() {
		// navigate to link and click on mobile tab
		home.clickMobile();
		
		//store xperia cost in a variable
		String xperiaCost = mobilePage.getxperiaPrice();
		
		//click on sony experia mobile
		mobilePage.clickXperia();
		// get xperia price fro details page
		String detailXperiaPrice = detail.getxperiaPrice();
		
		//check if the price is equal
		Assert.assertEquals(xperiaCost, detailXperiaPrice);
		
	}
	
	@Test(groups= {"mobile"})
	public void checkCompare() throws InterruptedException {
		home.clickMobile();
		
		// get elements to compare 
		List<String> items = mobilePage.getProductsName();
		
		//add elements to compare
		comparePagePOM compare = mobilePage.addToCompare();
		
		// verify the title of the compare window
		String title = "COMPARE PRODUCTS";
		Assert.assertEquals(title, compare.commparePageTitle());
		
		// Verify if the products are reflected on the compare page
		List<String> compareItems = compare.itemsOnCompareTab();
		for (int i = 0; i < compareItems.size(); i++) {
			Assert.assertEquals(items.get(i), compareItems.get(i));
		}
		
		// close the compare tab
		compare.closeCompareTab();
		
	}
	

}
