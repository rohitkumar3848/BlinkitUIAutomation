package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScrollUtil;
import utils.WaitUtil;

import java.util.List;

public class SearchPage {

    @FindBy(xpath = "//input[@placeholder='Search for']")
    private WebElement searchBox;

    // All real product cards
    @FindBy(xpath = "//div[@role='button' and contains(@class,'tw-relative') and contains(@class,'tw-h-full')]")
    private List<WebElement> productCards;

//    // Product name inside each card
//    @FindBy(xpath = ".//div[contains(@class,'tw-text-300') and contains(@class,'tw-font-semibold')]")
//    private WebElement productText; // used via relative search

    public SearchPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void searchProduct(String item){
        WaitUtil.getWait()
                .until(ExpectedConditions.visibilityOf(this.searchBox))
                .clear();
        this.searchBox.sendKeys(item);
    }

    public void selectProductByName(String productName){

        WaitUtil.getWait()
                .until(ExpectedConditions.visibilityOfAllElements(this.productCards));

        for (WebElement product : this.productCards) {

            // relative find inside each card
            WebElement nameElement =
                    product.findElement(
                            By.xpath(
                                    ".//div[contains(@class,'tw-text-300') and contains(@class,'tw-font-semibold')]"
                            )
                    );

            String actualName = nameElement.getText().trim();

            if (actualName.equalsIgnoreCase(productName)) {
                ScrollUtil.scrollToElement(product);
                WaitUtil.getWait()
                        .until(ExpectedConditions.elementToBeClickable(product));
                product.click();
                return;
            }
        }

        throw new RuntimeException("Product not found: " + productName);
    }
}
