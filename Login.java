package StepDefs;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {
	static WebDriver driver;
		
		@Given("^user is on home page$")
		public void user_is_on_home_page() {
			
			String exePath = "d://infy//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
		}

		@When("^user navigates to login page$")
		public void user_navigates_to_login_page() throws InterruptedException  {
		    // Write code here that turns the phrase above into concrete actions
			//driver.get("http://advantageonlineshopping.com");
			driver.navigate().to("http://advantageonlineshopping.com");
			Thread.sleep(1000);
			Assert.assertTrue(driver.getTitle().contains("Advantage Shopping"));
				
		     
		}


@When("^user enters correct \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_correct(String arg1, String arg2) throws Throwable {

	System.out.println(arg1 + "   " + arg2);
    
	WebElement element = driver.findElement(By.id("menuUser")); 
	element.click();
	driver.findElement(By.name("username")).sendKeys(arg1);
    driver.findElement(By.name("password")).sendKeys(arg2);	
    
    element = driver.findElement(By.id("sign_in_btnundefined"));
	JavascriptExecutor executor = (JavascriptExecutor)driver; 
    executor.executeScript("arguments[0]. click();", element);
    
		}
		
		@Then("^login is successful$")
		public void login_is_successful() {
		    // Write code here that turns the phrase above into concrete actions
			//Check if My Account is displayed in the page
			
			
			boolean exists = driver.findElement( By.id("menuUserLink")).isDisplayed();
	        System.out.println(driver.findElement( By.id("menuUserLink")).getText());
			System.out.println(exists);
	if (!exists) {
		assert(false);
	}
			driver.close();
		}
}