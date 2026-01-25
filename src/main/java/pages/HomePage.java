package pages;

import base.DriverFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public class HomePage {

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'Spin')]")
    private  WebElement overlay;



    public HomePage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickLogin(){
        try{
          //  System.out.println("check overlay btn  -->"+this.overlay.getText());


//        // WAIT till overlay disappears
//        WaitUtil.getWait()
//                .until(ExpectedConditions.invisibilityOf(
//                        this.overlay)
//                );

            Thread.sleep(2000);
            WaitUtil.getWait().until(ExpectedConditions.visibilityOf(this.loginBtn));
            WaitUtil.getWait().until(ExpectedConditions.elementToBeClickable(this.loginBtn));
            this.loginBtn.click();
        } catch (Exception e) {
            System.out.println("Exception in Homepage");
        }



    }
}
