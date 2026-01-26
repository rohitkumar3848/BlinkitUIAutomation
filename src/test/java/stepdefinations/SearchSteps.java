package stepdefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage=new SearchPage();

    @When("user searches product {string}")
    public void user_searches_product(String category) {
        searchPage.searchProduct(category);
    }
    @Then("user selects product {string}")
    public void user_selects_product(String productName) {
        searchPage.selectProductByName(productName);
    }
}
