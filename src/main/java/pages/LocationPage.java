package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public class LocationPage {

    @FindBy(xpath = "//button[contains(text(),'Detect my location')]")
    private WebElement detectLocationBtn;

    public LocationPage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    public void detectLocation(){
        WaitUtil.getWait()
                .until(ExpectedConditions.elementToBeClickable(this.detectLocationBtn));
       this.detectLocationBtn.click();
    }


}
