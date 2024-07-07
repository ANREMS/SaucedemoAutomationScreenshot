package step_definitions;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		//        tags = "@Cart",
//        features = {"classpath:features"},
		features = {"classpath:features/Login.feature",},
//	features = {"classpath:features/Login.feature","classpath:features/Cart.feature"},
        glue = { "classpath:step_definitions"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"}
)

public class RunCukesTest extends AbstractTestNGCucumberTests {

}
