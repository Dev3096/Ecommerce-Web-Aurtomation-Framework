package TechPanda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.DetailsPagePOM;
import PageObjects.EmailUtil;
import PageObjects.HomePagePOM;
import PageObjects.MobilePagePOM;
import PageObjects.accountPagePOM;
import PageObjects.cartPagePOM;
import PageObjects.tvPagePOM;
import TestComponents.BaseTest;
import TestComponents.BaseTest2;

public class BackendPage extends BaseTest2{
	@Test(groups= {"backend"})
	public void backendData() throws IOException {
		myHome.mylogin();
		myHome.selectSales();
		myHome.getElements();
	}
	
	
}
