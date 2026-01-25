package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public class LoginPage {

    @FindBy(xpath = "//input[@data-test-id='phone-no-text-box']")
    private WebElement mobileInput;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueBtn;

//    @FindBy(xpath = "//div[contains(text(),'OTP Verification')]")
//    private WebElement otpHeaderWait;

    public LoginPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }



    public void enterMobileNumber(String mobileNum){
        WaitUtil.getWait().until(ExpectedConditions.visibilityOf(this.mobileInput)).sendKeys(mobileNum);
    }

    public void clickContinue(){
        WaitUtil.getWait().until(ExpectedConditions.elementToBeClickable(this.continueBtn)).click();
    }


    public void otpScreenWait(){
       // WaitUtil.getWait().until(ExpectedConditions.invisibilityOf(this.otpHeaderWait));
        try{
            Thread.sleep(10000);
        }
        catch (Exception e){
            System.out.println("Exception in otpScreen");
        }
    }

}
