package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public class PaymentPage {

    @FindBy(xpath = "//div[text()='Select delivery address']")
    private WebElement paymentHeader;

    public PaymentPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public boolean isPaymentPageOpened(){
        return WaitUtil.getWait()
                .until(ExpectedConditions.visibilityOf(paymentHeader))
                .isDisplayed();
    }
}
