package StepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationTest{
    static WebDriver driver;
//THIS IS BACKGROUND CODE. BEFORE EACH SCENARIO, THIS WILL EXECUTE ONCE.
	
	@Given("^user is on automationpractice homepage$")
	public void user_is_on_automationpractice_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String exePath = "d://infy//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		/*driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		*/
		
		
		System.out.println("HOMEPAGE IN BACKGROUND STEP1");
	
	}

	@Then("^initialize webdriver$")
	public void initialize_webdriver() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("HOMEPAGE IN BACKGROUND STEP2");
		//driver.get("http://automationpractice.com/index.php");
		
	}

	// END OF BACKGROUND STEPS

	@Given("^user name is not yet registered$")
	public void user_name_is_not_yet_registered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		
	
	}

	
	
	@When("user registers with the right details {string} in the system")
	public void user_registers_with_the_right_details_in_the_system(String string) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("user registered with right details" + string);

	//EmailAddress - id - email_create

	//*[@id="SubmitCreate"]/span

	/*JavascriptExecutor j = (JavascriptExecutor) driver;
	
	j.executeScript("window.scrollBy(0,400)");
	
	driver.findElement(By.id("email_create")).sendKeys("abc@gmail.com");
	driver.findElement(By.id("SubmitCreate")).click();
	*/
	
	
}



@Then("^registration is successful$")
public void registration_is_successful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Registration is successful");
}


@Given("^user name is already registered$")
public void user_name_is_already_registered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Already registered username not available!Error!");
}

@When("^user registers with the username$")
public void user_registers_with_the_username() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^registration is unsuccessful$")
public void registration_is_unsuccessful() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Registration is unsuccessful");
    
}

}