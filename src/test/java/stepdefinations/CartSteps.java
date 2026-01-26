package stepdefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.PaymentPage;
import pages.ProductPage;

public class CartSteps {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    PaymentPage paymentPage = new PaymentPage();

    @When("user adds product to cart")
    public void user_adds_product_to_cart() {
        productPage.addToCart();
    }
    @When("user opens cart")
    public void user_opens_cart() {
        productPage.openCart();
    }
    @When("user proceeds to payment")
    public void user_proceeds_to_payment() {
        cartPage.proceedToPay();
    }
    @Then("payment page should open")
    public void payment_page_should_open() {
        Assert.assertTrue(
                paymentPage.isPaymentPageOpened(),
                "Payment page not opened"
        );
    }

}
