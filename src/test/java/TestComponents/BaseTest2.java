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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import PageObjects.DetailsPagePOM;
import PageObjects.HomePagePOM;
import PageObjects.HomePagebackendPOM;
import PageObjects.MobilePagePOM;
import PageObjects.accountPagePOM;
import PageObjects.cartPagePOM;
import PageObjects.checkOutPagePOM;
import PageObjects.dashboardPagePOM;
import PageObjects.ordersPagePOM;
import PageObjects.prevOrdersPOM;
import PageObjects.wishlistPagePOM;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest2 {
	protected WebDriver driver;
	protected HomePagebackendPOM myHome;
	
	Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		// properties class
		 prop = new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\GlobalData.properties");
		
		FileInputStream fis = new FileInputStream("D:\\Eclips workspace\\TechPanda\\src\\test\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
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
	public HomePagebackendPOM launchApp() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.manage().window().fullscreen();
		driver.get("http://live.techpanda.org/index.php/backendlogin/index/index/key/d2d0705d23357ea505aabd28b64b8050/");
		myHome = new HomePagebackendPOM(driver);
		Thread.sleep(2000);
		return myHome;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
//	@AfterSuite(alwaysRun=true)
//	public void sendEmail() {
//		//System.out.println("hello");
//		
//	}
	
	

}
