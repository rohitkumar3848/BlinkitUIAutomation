package stepdefinations;

import com.aventstack.extentreports.Status;
import hooks.Hooks;
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
        Hooks.extentTest.log(Status.PASS, "Product added to cart");
        Assert.assertTrue(true);
    }
    @When("user opens cart")
    public void user_opens_cart() {
        productPage.openCart();
        Hooks.extentTest.log(Status.PASS, "Cart opened");
        Assert.assertTrue(true);
    }
    @When("user proceeds to payment")
    public void user_proceeds_to_payment() {
        cartPage.proceedToPay();
        Hooks.extentTest.log(Status.PASS, "Clicked proceed to payment");
        Assert.assertTrue(true);
    }
    @Then("payment page should open")
    public void payment_page_should_open() {
        boolean status = paymentPage.isPaymentPageOpened();
        Hooks.extentTest.log(Status.INFO, "Payment page status: " + status);
        Assert.assertTrue(status, "Payment page not opened");
        Hooks.extentTest.log(Status.PASS, "Payment page opened successfully");
    }

}
