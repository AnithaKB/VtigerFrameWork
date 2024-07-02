package Practice;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        FileInputStream fis=new FileInputStream("./src\\test\\resources\\VtigerCommonData.properties.txt");
		
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		
		String USERNAME = pro.getProperty("username");
		String PWD = pro.getProperty("password");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		FileInputStream fis1=new FileInputStream("./src\\test\\resources\\VtigerExcelTestData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Contacts");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String name = cell.getStringCellValue();
	
		
		driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys(name);
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it = allWin.iterator();
		
		while(it.hasNext()) 
		{
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.contains("Accounts&action")) {
				break;
			}
		}
		driver.findElement(By.cssSelector("[name=\"search_text\"]")).sendKeys("");
	}

}
