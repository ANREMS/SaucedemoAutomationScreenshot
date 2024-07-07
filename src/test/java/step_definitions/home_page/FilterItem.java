package step_definitions.home_page;

import io.cucumber.java.en.When;
import org.example.pageObject.HomePage;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

public class FilterItem {

    private final WebDriver driver = Hooks.driver;

    HomePage homePage = new HomePage(driver);

    @When("User filters the list of product by text {string}")
    public void selectFilterProduct(String filterSelect) throws InterruptedException{
        homePage.filterItem(filterSelect);

    }





}
