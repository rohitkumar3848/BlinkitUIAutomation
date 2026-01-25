package runners;

import base.DriverFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocationPage;
import pages.LoginPage;
import utils.NavigationUtil;


public class Test1 {

    @Test
    public static void main(String []args){
        DriverFactory.initDriver();

        NavigationUtil.navigateToHome("Blinkit");
        LocationPage locationPage=new LocationPage();
        locationPage.detectLocation();
        HomePage   homePage=new HomePage();
        homePage.clickLogin();
        LoginPage loginPage=new LoginPage();
        loginPage.enterMobileNumber("9119740058");
        loginPage.clickContinue();

        // Just wait 5 sec to see browser
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {}
//
//        DriverFactory.quitDriver();
    }
}
