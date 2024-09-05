import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "StepDefinitions",
        monochrome = false, // color logs
        plugin = {"pretty", "json:target/reports/cucumber.json"})
public class TestRunner {
}
