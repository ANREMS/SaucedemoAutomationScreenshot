package step_definitions.checkout_and_cart_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutAndCartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import step_definitions.Hooks;

public class CheckoutItemFromCart {
    private final WebDriver driver = Hooks.driver;

    CheckoutAndCartPage checkoutAndCartPage = new CheckoutAndCartPage(driver);

    @When("User navigating to cart page")
    public void navigateToCartPage() {
        checkoutAndCartPage.clickCart();
    }

    @Then("User already on {string} as cart page")
    public void verifyOnCartPage(String msg){
        Assert.assertEquals( msg, checkoutAndCartPage.verifyOnCartPage());
    }

    @And("User navigating to checkout page")
    public void navigateToCheckoutPage() {
        checkoutAndCartPage.clickCheckout();
    }

    @And("User filling {string} as firstName, {string} as lastName and {string} as postal code")
    public void inputCredentials(String firstname, String lastname, String code) {
        checkoutAndCartPage.setFirstName(firstname);
        checkoutAndCartPage.setLastName(lastname);
        checkoutAndCartPage.setPostalCode(code);
    }

    @And("User navigating to checkout overview page")
    public void navigateToCheckoutOverview() {
        checkoutAndCartPage.clickContinue();
    }

    @And("User verifying item total and tax price")
    public void verifyingPrice(){
        Float totalItemPrice = (Float.parseFloat(checkoutAndCartPage.getItemPrice().substring(13)) + Float.parseFloat(checkoutAndCartPage.getTaxPrice().substring(6)));

        Float totalPrice = Float.parseFloat(checkoutAndCartPage.getTotalPrice().substring(8));

        Assert.assertEquals(totalItemPrice, totalPrice);
    }

    @Then("User navigating to checkout complete page and going back to home page")
    public void clickFinish() {
        checkoutAndCartPage.clickFinish();
        checkoutAndCartPage.clickBackToProduct();
    }

}
