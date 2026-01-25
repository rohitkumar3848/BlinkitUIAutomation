package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.NavigationUtil;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setUp() {
        String title=ConfigReader.get("title");
        DriverFactory.initDriver();
        NavigationUtil.navigateToHome(title);
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.screenShot(scenario.getName());
        }
        DriverFactory.quitDriver();
    }
    
}
