package TestRunners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features/loginHK.feature",
		glue={"StepDefs"},
		plugin = {"pretty", "html:target/cucumber/report.html","json:target/json/report.json","junit:target/XML/XMLREPORT.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/extent/cucumberreport17May.html"},
	
		//To ignore tests
		//tags = "~@SecurityTest",
        tags="@Functional",
		monochrome=true
			)
public class TestRunner17May {
	
	
	@AfterClass
	public static void writeExtentReport() {
	
		Reporter.loadXMLConfig("D://Infy//CucumberInfy05Apr2022//CucumberInfy05Apr2022//src//test//resources/extent-config.xml");
	
	}
	
	
}
