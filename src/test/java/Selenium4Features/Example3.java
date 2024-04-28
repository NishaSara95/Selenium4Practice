package Selenium4Features;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Example3 {
	
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\Driver\\chromedriver.exe");		
		//To access the Chrome dev tools then use ChromeDriver instead of Webdriver
		ChromeDriver driver = new ChromeDriver();
		
		//Get dev tools using driver.getDevTools
		DevTools devTools = driver.getDevTools();
		
		//Create a session using .creatSession method
		devTools.createSession();
		
		Map<String, Object> params = new HashMap<String, Object> ();
		
		params.put("latitude", 40);
        params.put("longitude",  3);
        params.put("accuracy", 1);
    
        
        driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
		
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        
       WebElement titles = driver.findElement(By.xpath("(//h3)[1]"));
        titles.click();
        String title = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(title);
	}

}
