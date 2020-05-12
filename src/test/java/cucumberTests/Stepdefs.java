package cucumberTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {
	private WebDriver browser;
	
	@Test
	@Given("^Open user form$")
	public void openUsersPage() throws Exception{
		WebDriverManager.chromedriver().setup();
		browser = new ChromeDriver();
		browser.get("http://localhost:4200/users/form");
		
		Dimension d = new Dimension(1200,800);
		browser.manage().window().setSize(d);
 		
		
		browser.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		WebElement el = browser.findElement(By.cssSelector(".formTitle"));
		Assert.assertEquals("Create User Form", el.getText());
	}
	@When("^A new user is added$")
	public void addNewUserUsingForm() throws Exception{
		// Type into form
		// Click submit button
		// Confirm users list page is loaded
	}
	@Then("^User shows on page$")
	public void getUserFromDOM() throws Exception{
		// Grab the first user from list
		// Check data against values added in the when
		
		browser.close();
	}
	
	
}
