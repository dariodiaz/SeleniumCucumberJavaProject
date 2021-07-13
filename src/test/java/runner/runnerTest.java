package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    monochrome = true,
    tags = {"@Test"}
)

public class runnerTest {
    @AfterClass
    public static void closeDriver() {
        BasePage.closeBrowser();
    }
}