package pages;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WaitUtil;

public class ProductPage {

    @FindBy(xpath = "//div[@role='button' and .//div[text()='Add to cart']]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(@class,'CartButton__Text') ]/ancestor::div[2]")
    private WebElement cartIcon;


    public ProductPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void addToCart(){
        WaitUtil.getWait()
                .until(ExpectedConditions.elementToBeClickable(addToCartBtn))
                .click();
    }

    public void openCart(){
        WaitUtil.getWait()
                .until(ExpectedConditions.elementToBeClickable(cartIcon))
                .click();
    }

}
