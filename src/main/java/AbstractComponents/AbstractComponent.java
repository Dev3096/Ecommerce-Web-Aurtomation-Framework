package AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	int scc;
	public AbstractComponent(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this);
	}

	// Reusable code is written in this class
	public void waitForElement(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void screenShot(String myString, WebDriver driver) throws IOException {
		scc = scc + 1;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png = ("D:\\Eclips workspace\\TechPanda\\" + myString + scc + ".png");
		FileUtils.copyFile(scrFile, new File(png));
	}
	

}
