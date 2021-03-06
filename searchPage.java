package StepDefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import Pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class searchPage {
	static WebDriver driver;
	static String srch;
	static boolean success;
	static String s;
	static Scenario curScenario;



	@Given("I am in homepage")
	public void i_am_in_homepage() {
		// Write code here that turns the phrase above into concrete actions
		String exePath = "d://chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);


//		Reporter.addStepLog("*******Begin scenario.");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://advantageonlineshopping.com/");



	}

	/*
	@When("^I enter a search keyword in the search box$")
	public void i_enter_a_search_keyword_in_the_search_box(DataTable table)  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<List<String>> rows = table.asLists(String.class);

		for (List<String> columns : rows) {
			System.out.println(columns.get(0));

		}

	}
*/

	
	@When("I enter a search keyword in the search box")
	public void i_enter_a_search_keyword_in_the_search_box(DataTable dataparam) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.


		//instantiate the page class
		HomePage home = new HomePage(driver);


		List<Map<String,String>> data = dataparam.asMaps(String.class, String.class);

		int numrows = data.size();
		System.out.println(" Rows : " + numrows);

		for(int i = 0;i < numrows;i++)
		{	

			s = data.get(i).get("Productname");

			//PERFORM THE SEARCH
			
			success= home.searchfor(s);
			System.out.println("Search for : " + s + " is :" + success);
			//Reporter.addStepLog("Search for : " + s + " is :" + success);

			//TC for checking the visibility of username textbox
			//System.out.println("Username box visibility:" + home.isUsernameBoxVisible());


			//Assert.assertEquals(true, success);
			driver.get("http://advantageonlineshopping.com/");


		}
	}
	

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		// Write code here that turns the phrase above into concrete actions



	}

}





