package Selenium4Features;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;


public class Example2 {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\Driver\\chromedriver.exe");		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> params = new HashMap<String, Object> ();
		
		params.put("width", 412);
        params.put("height", 915);
        params.put("deviceScaleFactor", 46);
        params.put("mobile", true);
		
		
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(4000);
		
		System.out.println(currentUrl);
		WebElement menu = driver.findElement(By.xpath("//*[@aria-label='Toggle navigation']"));
		menu.click();
		WebElement title = driver.findElement(By.xpath("//*[text()='RahulShettyAcademy']"));
		Assert.assertEquals(title.getText(), "RahulShettyAcademy");
		driver.quit();
		
	}
}
