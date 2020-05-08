package cucumberTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {
	private WebDriver browser;
	
	@Test
	@Given("^The web browser is opened on google home$")
	public void startChromeWithGoogle() throws Exception{
		WebDriverManager.chromedriver().setup();
		browser = new ChromeDriver();
		browser.get("http://localhost:4200/users/list");
		
		WebElement el = browser.findElement(By.cssSelector("body"));
		System.out.println(el.getText());
//		Boolean isPageTitleOk = pageTitle.equals("Google");
//		assertTrue(isPageTitleOk);
		
//		browser.close();
	}
	
	
}
