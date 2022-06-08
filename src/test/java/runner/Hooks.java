package runner;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    // Run before all the scenarios
    @BeforeAll
    public static void beforeAll(){
        System.out.print("\nHere is before All on Hooks Class");
    }
    // run before each scenario, for scenario outline, run before its example.
    @Before (order = 0)
    public void beforeHook0(){
        System.out.print("\nHere is BEFORE HOOK 0 on Hooks Class and run the THREAD ID: " + Thread.currentThread().getId());
        // set default browser is chrome
        driver = DriverFactory.initializerDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    //run before hook with order = 0 >> run order = 1 >> @tag . After hook is CONTRARY
    @Before (order = 1)
    public static void beforeHook1(){
        System.out.print("\nHere is BEFORE HOOK 1 on Hooks Class");
    }


    @Before ("@Smoke")
    public static void beforeHookTag() {
        System.out.print("\nHere is BEFORE HOOK with tag @Smoke on Hooks Class");
    }

    //===========================================

    // Just run this after hook for specified scenarios which is added tag as @smoke
    @After ("@Smoke")
    public static void afterHookSmoke(Scenario scenario){
        System.out.print("\nHere is AFTER HOOK with tag @smoke on Hooks Class");
    }

    @After (order = 1)
    public void afterHook1(Scenario scenario){
        System.out.print("\nHere is AFTER HOOK 1 on Hooks Class");
        scenario.getName();
        scenario.getStatus();
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        //(screenshot, "image/png");
        }
    }
    //run after hook with: @Tag >> order = 1 >> run order = 0. CONTRARY TO BEFORE HOOK
    @After (order = 0)
    public void afterHook0(Scenario scenario){
        System.out.print("\nHere is AFTER HOOK 0 on Hooks Class");
        driver.quit();
    }


    @AfterAll
    public static void afterAll(){
        System.out.print("\nHere is After All on Hooks Class");
    }

}
