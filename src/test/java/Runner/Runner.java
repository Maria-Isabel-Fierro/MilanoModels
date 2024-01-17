package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(tags = "@TestMilano",
        features = "./src/test/java/Feature/",
        glue = {"Step"})

public class Runner {
}