package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue =  {"steps", "hook"}, // Inclua o pacote de hooks aqui
        tags = "@regressivo",
        plugin = {"html:target/cucumber-reports.html"}
)

public class TestRunner {
}