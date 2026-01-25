package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.NavigationUtil;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {

        String title = ConfigReader.get("title");

        DriverFactory.initDriver();
        NavigationUtil.navigateToHome(title);

        // ---- AUTO LOGIN FLOW ----
        LocationPage locationPage = new LocationPage();
        locationPage.detectLocation();

        HomePage homePage = new HomePage();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.enterMobileNumber(ConfigReader.get("mobile"));
        loginPage.clickContinue();

        try {
            Thread.sleep(20000); // manual OTP
        } catch (Exception e) {}
    }



    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.screenShot(scenario.getName());
        }
        DriverFactory.quitDriver();
    }
    
}
