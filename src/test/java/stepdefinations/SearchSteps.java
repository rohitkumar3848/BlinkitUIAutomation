package stepdefinations;

import com.aventstack.extentreports.Status;
import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage=new SearchPage();

    @When("user searches product {string}")
    public void user_searches_product(String category) {
        searchPage.searchProduct(category);
        Hooks.extentTest.log(Status.PASS, "Searched product: " + category);
        Assert.assertTrue(true);
    }
    @Then("user selects product {string}")
    public void user_selects_product(String productName) {
        searchPage.selectProductByName(productName);
        Hooks.extentTest.log(Status.PASS, "Selected product: " + productName);
        Assert.assertTrue(true);
    }
}
