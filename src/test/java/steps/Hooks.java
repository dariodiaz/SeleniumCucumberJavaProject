package steps;

import io.cucumber.java.*;
import io.cucumber.core.runner.Options;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
          if(scenario.isFailed()) {
            //   scenario.write("There was a failure when running the code, refer to the screenshot in the report");
            //   final byte[] screenshot = ((TakesScreenshot) driver)
            //           .getScreenshotAs(OutputType.BYTES);
            //   scenario.embed(screenshot, "image/png");
          }
    }

}
