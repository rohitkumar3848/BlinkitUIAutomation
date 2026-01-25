package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;

public class LoginSteps {

    LocationPage locationPage=new LocationPage();
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();

    @Given("user detects delivery location")
    public void user_detects_delivery_location() {
        locationPage.detectLocation();
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        homePage.clickLogin();
    }

    @When("User enters mobile number {string}")
    public void user_enters_mobile_number(String mobileNumber) {
        loginPage.enterMobileNumber(mobileNumber);
    }

    @When("User clicks continue")
    public void user_clicks_continue() {
        loginPage.clickContinue();
    }

    @Then("OTP screen should appear")
    public void otp_screen_should_appear() {
        System.out.println("OTP screen dispalyed");
        loginPage.otpScreenWait();
        System.out.println("OTP screen invisible");
    }

}
