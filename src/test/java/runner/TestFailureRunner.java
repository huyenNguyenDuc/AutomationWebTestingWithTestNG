package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions
        (       features={"@target/rerun/failed_scenarios.txt"},
                glue = {"testSteps", "runner", "objects", "customtype", "constants"},
                plugin={"pretty","json:target/cucumber-reports/CucumberTestReport.json"}
        )
public class TestFailureRunner extends AbstractTestNGCucumberTests {
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
