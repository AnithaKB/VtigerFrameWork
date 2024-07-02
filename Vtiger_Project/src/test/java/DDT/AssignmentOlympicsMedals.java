package DDT;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssignmentOlympicsMedals {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()=\"No, manage settings\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"Reject All\"]")).click();
		
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		
		WebElement Gold = driver.findElement(By.xpath("//span[text()=\"Argentina\"]/ancestor::div[@class=\"sc-SljiV sc-ffsIOD dKpkoX dgJqtI\"]/descendant::div[@title=\"Gold\"]"));
//        System.out.println(Gold.getText());
		
	}

}
