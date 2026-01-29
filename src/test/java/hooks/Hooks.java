package hooks;

import base.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.NavigationUtil;
import utils.ScreenshotUtil;

public class Hooks {

    public static ExtentReports extentReports = ExtentManager.getExtentReports();
    public static ExtentTest extentTest;

    @Before
    public void setUp(Scenario scenario) {

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


        extentTest = extentReports.createTest(scenario.getName());
        extentTest.info("Browser opened and Blinkit launched");
    }

    @BeforeStep
    public void beforeStep() {
        extentTest.info("Starting step");
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            extentTest.fail("Step failed");
        } else {
            extentTest.pass("Step executed successfully");
        }
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.screenShot(scenario.getName());
        }
        DriverFactory.quitDriver();
        extentReports.flush();
    }
    
}
