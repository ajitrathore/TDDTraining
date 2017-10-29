package tdd.training.timeline.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Ajit on 2/22/17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:features/",
        glue = "classpath:tdd/training/timeline/bdd"

)
public class CucumberRunnerIT {

}

