package testrunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/handleWindow.feature"},
		glue = {"stepdefinitions", "Apphooks"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				//this will create a thread and  tell us parellel execution is happened
},
		monochrome = true
                 )


public class MyTestRunner {

}