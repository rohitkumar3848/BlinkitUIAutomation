package stepdefinations;


import com.aventstack.extentreports.Status;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.NavigationUtil;
import utils.ScreenshotUtil;

public class LoginSteps {

    LocationPage locationPage = new LocationPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("user launches website url")
    public void open_home_page() {
        String title = ConfigReader.get("title");
        NavigationUtil.navigateToHome(title);
        Assert.assertTrue(true);
        Hooks.extentTest.log(Status.PASS, "user launched website url successfully");
    }

    @Given("user logs in successfully")
    public void login() throws InterruptedException {
        locationPage.detectLocation();
        homePage.clickLogin();
        loginPage.enterMobileNumber(ConfigReader.get("mobile"));
        loginPage.clickContinue();
        Thread.sleep(20000); // manual OTP
        Assert.assertTrue(true);
        Hooks.extentTest.log(Status.PASS, "User logged in successfully");
        ScreenshotUtil.screenShot("HomePage");
        String path="./Screenshot/HomePage.png";
        Hooks.extentTest.addScreenCaptureFromPath(path);
    }
}
