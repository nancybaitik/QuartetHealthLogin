package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml",
        "rerun:target/rerun.txt"},
        features = "src/test/resources/LoginPage.feature",
        glue = "StepDefinitions",
        dryRun = false

)
public class LoginPageRunner {



}
