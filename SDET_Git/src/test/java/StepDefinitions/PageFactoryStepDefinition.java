package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.homePageFactory;
import pageFactory.loginPageFactory;

public class PageFactoryStepDefinition {
	static WebDriver driver;
	loginPageFactory login;
	homePageFactory home;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://www.saucedemo.com/");
	}

	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
		login = new loginPageFactory(driver);
		login.enterUsername(username);
	    login.enterPassword(password);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
	    login.clickLoginButton();
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		home = new homePageFactory(driver);
		home.isCartDisplayed();
	    
	}

	@And("user close the browser")
	public void user_close_the_browser() {
	    driver.close();
	}

}
