package Selenium4Features;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.emulation.Emulation;
import org.testng.Assert;

public class Example1 {
	
	
	/** 1. From Selenium 4 the Chrome driver and Edge Driver classes will be inherited from Chromium Driver and not from Remote Webdriver 
	 * 	2. To access the Chrome dev tools then i should use ChromeDriver instead of Webdriver
	 * 	3. Get dev tools using driver.getDevTools
	 * 	4. Create a session using .creatSession method
	 * 	5. Send command to CDP by firing events 
	 * 
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\Driver\\chromedriver.exe");		
		//To access the Chrome dev tools then use ChromeDriver instead of Webdriver
		ChromeDriver driver = new ChromeDriver();
		
		//Get dev tools using driver.getDevTools
		DevTools devTools = driver.getDevTools();
		
		//Create a session using .creatSession method
		devTools.createSession();
		
		//Send command to CDP by firing events
		devTools.send(Emulation.setDeviceMetricsOverride(412, 915, 46, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		Thread.sleep(4000);
		
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
