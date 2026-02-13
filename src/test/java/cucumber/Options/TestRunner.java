package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/java/features/AddPet.feature",plugin="json:target/jsonReports/cucumber-Report.json", glue={"StepDefinitions"})
  // tags= "@Addplace")

public class TestRunner {

}
