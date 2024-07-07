package step_definitions.checkout_and_cart_page;

import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutAndCartPage;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

public class RemoveItemFromCart {
    public WebDriver driver = Hooks.driver;

    CheckoutAndCartPage checkoutAndCartPage = new CheckoutAndCartPage(driver);

    @When("User remove all item in cart")
    public void removeAllItemFromCart() {
        for(int i = 0; i < Integer.parseInt(checkoutAndCartPage.getBadgeTextCart()); i++) {
            checkoutAndCartPage.clickRemoveItem();
        }
    }

    @When("User remove first item in cart")
    public void removeItemFromCart() {
        checkoutAndCartPage.clickRemoveItem();
    }
}
