package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        // we can run for Tags with tag expressions: @a and @b, @a and not @b, @a or @b
        // Run test with maven command:
        // mvn clean test -Dcucumber.filter.tags=@testing
        // link for more details: https://cucumber.io/docs/cucumber/api/
        plugin = {"pretty", "html:src/report/cucumber-report.html"}, tags = "@testing",
        //monochrome = true,
        glue = {"testSteps", "runner", "objects", "customtype", "constants"},
        features = "src/test/resources/testSteps"
)
public class TestNGRunnerTesting extends AbstractTestNGCucumberTests {

    @Override
    // set run parallel
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.print("\nHere is before Class on TestNG annotation\n");
    }

    @AfterClass
    public void afterClass() {
        System.out.print("\nHere is after Class on TestNG annotation\n");
    }
}
