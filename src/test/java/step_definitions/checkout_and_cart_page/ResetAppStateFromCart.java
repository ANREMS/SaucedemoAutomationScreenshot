package step_definitions.checkout_and_cart_page;

import org.example.pageObject.CheckoutAndCartPage;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import step_definitions.Hooks;

public class ResetAppStateFromCart {

	private final WebDriver driver = Hooks.driver;

    CheckoutAndCartPage checkoutAndCartPage = new CheckoutAndCartPage(driver);
    
    @Then("User reset app state")
	public void resetAppState() {
		checkoutAndCartPage.clickSideMenu();
		checkoutAndCartPage.clickReset();
	}
}
