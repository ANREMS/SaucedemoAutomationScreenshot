package step_definitions.login_page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

public class LoginWithValidData {

    private final WebDriver driver = Hooks.driver;

    LoginPage loginPage = new LoginPage(driver);

    @Given("User already open the website sauce demo")
    public void verifyLoginPage() {
        Assert.assertTrue(loginPage.verifyOnLoginPage());
    }

    @When("User input {string} as username {string} as password")
    public void inputCredential(String username, String password) {
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickButtonLogin();
    }

    @Then("User already on homepage")
    public void verifyAlreadyOnHomePage() {
        Assert.assertTrue(loginPage.loginIsSuccessful());
    }

}