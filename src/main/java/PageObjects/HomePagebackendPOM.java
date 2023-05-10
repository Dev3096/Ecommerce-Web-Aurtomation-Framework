package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class HomePagebackendPOM extends AbstractComponent{
	WebDriver driver;
	public HomePagebackendPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="login")
	WebElement password;
	
	@FindBy(css=".form-button")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"message-popup-window\"]/div[1]/a")
	WebElement close;
	
	@FindBy(xpath="//*[@id=\"nav\"]/li[1]/a")
	WebElement sales;
	
	@FindBy(xpath="//*[@id=\"nav\"]/li[1]/ul/li[1]/a")
	WebElement Orders;
	
	public void mylogin() {
		userName.sendKeys("user01");
		password.sendKeys("guru99com");
		login.click();
		close.click();
	}
	
	public void selectSales() {
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(sales).perform();
		Orders.click();
		
	}
	
	public void getElements() throws IOException {
		//*[@id="sales_order_grid_table"]/tbody/tr[1]/td[2]
		////*[@id="sales_order_grid_table"]/tbody/tr[2]/td[3]
		////*[@id="sales_order_grid_table"]/tbody/tr[3]/td[3]
		//*[@id="sales_order_grid_table"]/tbody/tr[1]/td[8]
		
		File file = new File("D:\\Eclips workspace\\TechPanda\\loginDetails.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook loginDetails = new XSSFWorkbook(inputstream);
		Sheet mySheet = loginDetails.getSheet("login");
		int sheetRowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();
		System.out.println(sheetRowCount);
		Row row = mySheet.getRow(0);
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"sales_order_grid_table\"]/tbody/tr"));
		System.out.println(rows.size());
		int rowCount = rows.size();
		for (int i = 1; i <=rowCount; i++) {
			Row newRow = mySheet.createRow(i);
			for (int j = 1; j <= 8; j++) {
				String data = driver.findElement(By.xpath("//*[@id=\"sales_order_grid_table\"]/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				Cell cell = newRow.createCell(j);
				cell.setCellValue(data);
				//System.out.println(data);
			}
			
		}
		inputstream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		loginDetails.write(outputStream);
		outputStream.close();
	}
	
	
	
	
}
