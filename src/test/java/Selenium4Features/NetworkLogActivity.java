package Selenium4Features;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.Headers;
import org.openqa.selenium.devtools.v121.network.model.Request;
import org.openqa.selenium.devtools.v121.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\Driver\\chromedriver.exe");
		// To access the Chrome dev tools then use ChromeDriver instead of Webdriver
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Log file

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), req -> {

			Request request = req.getRequest();
			Headers headers = request.getHeaders();
			System.out.println("headers" + headers);

		});

		// Event getting fired to receive the response
		devTools.addListener(Network.responseReceived(), response -> {

			Response totalResponse = response.getResponse();
			String url = totalResponse.getUrl();
			Integer statusCode = response.getResponse().getStatus();
			System.out.println("StatusCode" + statusCode);
			System.out.println("url" + url);

		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		WebElement virtualLib = driver.findElement(By.cssSelector("[data-toggle='modal']"));
		virtualLib.click();

	}

}
