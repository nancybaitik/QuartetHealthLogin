package StepDefinitions;

import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver = Driver.getDriver();
    // We have before and after annotations.
    // Those are coming from the Cucumber.
    // They will run before and after each scenario
    // We have one Scenario interface to get the details from every scenario
    @Before
    public void setUp(Scenario scenario){
     //   System.out.println("Before scenario");
        System.out.println(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
   //     System.out.println("After each scenario");

        if (scenario.isFailed()){
            System.out.println("Failed");

        }


    }
}
