package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJasonFile {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src\\test\\resources\\Jason_File.json");
		
		ObjectMapper jsonData = new ObjectMapper();
		JsonNode data = jsonData.readTree(file);
		
		String URL = data.get("url").asText();
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		
		String UN = data.get("username").asText();
		String PWD = data.get("password").asText();
		
		driver.findElement(By.name("user-name")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.className("btn_action")).click();
		

	}

}
