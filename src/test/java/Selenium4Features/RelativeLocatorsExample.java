package Selenium4Features;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorsExample {
	
	// Newly added Relative locators : above, below, toLeftOf, toRightOf
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameText = driver.findElement(By.cssSelector("[name='name']"));
        String labeltext = driver.findElement(with(By.tagName("label")).above(nameText)).getText();
        System.out.println(labeltext);
        
        
        WebElement emailLabel = driver.findElement(By.xpath("//*[text()='Email']"));
         driver.findElement(with(By.tagName("input")).below(emailLabel)).clear();
         driver.findElement(with(By.tagName("input")).below(emailLabel)).sendKeys("nishasaran1006@gmail.com");

	}

}
