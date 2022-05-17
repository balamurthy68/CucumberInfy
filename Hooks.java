package StepDefs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
  public static WebDriver driver;
	  
   
   @Before
   public void setup()
   {
		
	   System.out.println("Before hook running");
	   
   }
   
   @Before("@SecurityTest") 
   public void executebeforesecuritytest()
   {
        
	    	
	   System.out.println("Before SECURITY TEST hook running");
		   
   }
   
	@After
	public void teardown()
	{
		System.out.println("After hook running");
		
	}

   
}
