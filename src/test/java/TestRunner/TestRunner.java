package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.awt.*;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
                    glue={"StepDef"},
                    plugin={"pretty","json:target/cucumber.json"})
public class TestRunner {
}