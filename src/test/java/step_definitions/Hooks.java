package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Base64;

public class Hooks {

    public static WebDriver driver;

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void openBrowser(Scenario scenario) {
        String appUrl = "https://www.saucedemo.com/";
        driver = new ChromeDriver();
        driver.get(appUrl);
        driver.manage().window().maximize();
        
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("extent.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotPath = "data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot);
                test.get().addScreenCaptureFromPath(screenshotPath);
                test.get().fail("Test failed");
            } catch (Exception e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            }
        } else {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotPath = "data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot);
                test.get().addScreenCaptureFromPath(screenshotPath);
                test.get().pass("Test passed");
            } catch (Exception e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            }
        }

        extent.flush();
        driver.quit();
    }
}
