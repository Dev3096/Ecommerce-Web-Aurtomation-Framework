package TechPanda;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DetailsPagePOM;
import PageObjects.HomePagePOM;
import PageObjects.MobilePagePOM;
import PageObjects.accountPagePOM;
import PageObjects.cartPagePOM;
import PageObjects.tvPagePOM;
import TestComponents.BaseTest;

public class AccountPage extends BaseTest{
	int scc = 0;
	static String orderNo;
	@Test(groups= {"accounts"},retryAnalyzer=TestComponents.RetryFailed.class)
	public void createAccount() throws InterruptedException, IOException {
		home.clickAccount();
		
		//click on my account
		home.clickMyAccount();
		
		//click on create account link
		acc.clickCreatAccount();
		
		//fill in the user details and click on register
		acc.userDetails();
		Thread.sleep(2000);
		
		//click on tv link 
		tvPagePOM myTv = acc.goToTV();
		
		// add "LG LCD" to wishlist
		myTv.addToWishList();
		
		//share wishlist
		String uiMessage = myTv.shareWishlist();
		Thread.sleep(2000);
		
		//Verify that the wishlist is shared
		String verify = "Your Wishlist has been shared.";
		//String verify = "Your Wishlist has not been shared.";
		Assert.assertEquals(verify, uiMessage);
		
	}
	
	@Test(groups = {"checkOut"})
	public void loginAccount() throws InterruptedException, IOException {
		
		home.clickAccount();
		home.clickMyAccount();
		
		// login using valid credentials
		acc.login();
		
		//click on my wishlist on dashboard page
		dash.clickWishList();
		
		// click on add to cart from my wishlist page
		page.addElementTOCart();
		
		// click on proceed to checkout from cart page
		cart.clickProceedToCheckOut();
		
		//enter billing information 
		checkout.enterBillingInfo();
		
		//click on continue
		checkout.clickContinue();
		
		//verify that 5$ fixed shipping rate is applied
		String shippingrate = "$5.00";
		Assert.assertEquals(shippingrate, checkout.getShippingPrice());
		
		//click on continue
		checkout.clickContinueAfterShipping();
		
		// select Check/Money Order
		checkout.clickCheck();
		
		// click on continue
		checkout.clickContinueAfterPayment();
		
		//click on place order
		checkout.clickPlaceOrder();
		
		Thread.sleep(2000);
		
		//verify order is placed
		
		String verify = "YOUR ORDER HAS BEEN RECEIVED.";
		String confirm = orders.confirmOrder();
		Assert.assertEquals(verify, confirm);
		
		// get the order number
		orderNo = orders.getOrderNumber();
		System.out.println(orderNo);
		
	}
	
	@Test(groups= {"orders"})
	public void verifyOrderPlaced() throws InterruptedException {
		home.clickAccount();
		home.clickMyAccount();
		acc.login();
		dash.clickMyOrders();
		dash.clickViewOrder();
		
		String orderVerify = "ORDER " + "#" + orderNo + " - PENDING"; 
		String verify = prevOrder.getOrderNumberVerified();
		System.out.println(verify);
		System.out.println(orderVerify);
		//Assert.assertEquals(orderVerify, verify);
		
		prevOrder.clickPrintOrder();
		
		//prevOrder.printOrder();
		
	}
	
	
	
	
	
}
