package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.DetailsPagePOM;
import PageObjects.HomePagePOM;
import PageObjects.MobilePagePOM;
import PageObjects.accountPagePOM;
import PageObjects.cartPagePOM;
import PageObjects.checkOutPagePOM;
import PageObjects.dashboardPagePOM;
import PageObjects.ordersPagePOM;
import PageObjects.prevOrdersPOM;
import PageObjects.wishlistPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	protected HomePagePOM home;
	protected MobilePagePOM mobilePage;
	protected accountPagePOM acc;
	protected dashboardPagePOM dash;
	protected wishlistPagePOM page;
	protected DetailsPagePOM detail;
	protected cartPagePOM cart;
	protected checkOutPagePOM checkout;
	protected ordersPagePOM orders;
	protected prevOrdersPOM prevOrder;
	Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		// properties class
		 prop = new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
		
		FileInputStream fis = new FileInputStream("D:\\Eclips workspace\\TechPanda\\src\\test\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		// below ternary operator check if we are selecting browser from maven terminal 
		// if not it takes the browser from properties file only
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			//firefox
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "D:\\Eclips workspace\\Grid\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (browserName.equals("edge")) {
			// edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public HomePagePOM launchApp() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().fullscreen();
		driver.get("http://live.techpanda.org/index.php/");
		home = new HomePagePOM(driver);
		mobilePage = new MobilePagePOM(driver);
		acc = new accountPagePOM(driver);
		dash = new dashboardPagePOM(driver);
		page = new wishlistPagePOM(driver);
		detail = new DetailsPagePOM(driver);
		cart = new cartPagePOM(driver);
		checkout = new checkOutPagePOM(driver);
		orders = new ordersPagePOM(driver);
		prevOrder = new prevOrdersPOM(driver);
		Thread.sleep(2000);
		return home;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String getscreenShot(String TestName, WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String png = ("D:\\Eclips workspace\\TechPanda\\" + TestName  + ".png");
		File file = new File(System.getProperty("user.dir") + "//reports//" + TestName + ".png");
		FileUtils.copyFile(scrFile, file);
		return System.getProperty("user.dir") + "//reports//" + TestName + ".png";
	}
	

}
