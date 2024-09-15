import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "stepDefinitions",
        monochrome = false, // color logs
        plugin = {"pretty",
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/reports/html/report.html",
                "json:target/reports/json/cucumber.json"})
public class TestRunner {
}
