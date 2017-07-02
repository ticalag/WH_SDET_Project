package test.technical.sdet;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Gabi on 6/28/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".",  format = {"pretty", "html:target/CucumberReports"}
)
public class CucumberRunTest {
}
