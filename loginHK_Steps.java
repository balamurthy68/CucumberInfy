package StepDefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class loginHK_Steps {
	
	public static WebDriver driver;
	public LoginPage lp;
	
		
	@Given("^Herokuapp login page is opened$")
		public void herokuapp_login_page_is_opened() {
		    // Write code here that turns the phrase above into concrete actions
		    //driver instantiation
			//driver.get url
	
			System.out.println("BACKGROUND EXECUTING");
			System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
			
	    	driver = new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://the-internet.herokuapp.com/login");
			
			lp = new LoginPage(driver);
	
			System.out.println("page is opened");
		
			
			//get the title,compare with expected title and assert
		}

		@When("^correct username \"([^\"]*)\" is entered and correct password \"([^\"]*)\" is entered$")
		public void correct_username_is_entered_and_correct_password_is_entered(String un, String pw) {
		    // Write code here that turns the phrase above into concrete actions
			
			lp.typeusername(un);
			lp.typepassword(pw);
			
			System.out.println("Entered correct username  " + un + " Password :" + pw );
		}

		
		@And("^click on Login button$")
		public void click_on_Login_button()  {
		    // Write code here that turns the phrase above into concrete actions
		
			System.out.println("Login button clicked ");
			lp.clickLoginButton();
			
		}
		
		

		@Then("^I should find the Welcome message$")
		public void i_should_find_the_Welcome_message()  {
		    // Write code here that turns the phrase above into concrete actions
		
			boolean success;
			
			//validate using flash area
		
			String expectedSuccessMsg ="You logged into a secure area!";
			String actualMsg = lp.getLoginStatus();
			if (actualMsg.contains(expectedSuccessMsg)) {
				
			    success = true;	
				System.out.println("Login Success");
				lp.clickLogOutbutton();
			}
			else
			{
				success = false;
			}
			
			Assert.assertEquals(true, success);
			driver.close();
		}

		  	
		
/*----------------------------------------------------
 * Unsuccessful login scenario
 */
		
		@When("^incorrect username \"([^\"]*)\" is entered and incorrect password \"([^\"]*)\" is entered$")
		public void incorrect_username_is_entered_and_incorrect_password_is_entered(String un, String pw)  {
		    // Write code here that turns the phrase above into concrete actions
			lp.typeusername(un);
			lp.typepassword(pw);
			
			System.out.println("Entered incorrect username  " + un + "Password :" + pw );
		    
		}

		@Then("^I should not find the Welcome message$")
		public void i_should_not_find_the_Welcome_message() {
		    // Write code here that turns the phrase above into concrete actions

			boolean success;
			
			//validate using flash area
		
			String expectedSuccessMsg ="You logged into a secure area!";
			String actualMsg = lp.getLoginStatus();
			if (actualMsg.contains(expectedSuccessMsg)) {
				
			    success = false;	
				System.out.println("WARNING - SECURITY BREACH - Logging in for incorrect credentials");
				System.out.println("Reason for not logging in :" + actualMsg);
				lp.clickLogOutbutton();
			}
			else
			{
				success = true;
				System.out.println("********Reason for not logging in :" + actualMsg);
			}
			
			Assert.assertEquals(true, success);
			//driver.close();
		}

		
		
		@Then("^reload the login page$")
		public void reload_the_login_page()  {
		    // Write code here that turns the phrase above into concrete actions
			driver.get("https://the-internet.herokuapp.com/login");
        
		}

		@After("@SecurityTest")
		public void teardownsecuritytest()
		{
			driver.quit();
		}

}
