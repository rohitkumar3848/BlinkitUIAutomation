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

    // Step 1: Wrapper (always visible)
    @FindBy(xpath = "//div[contains(@class,'SearchBar__AnimationWrapper')]")
    private WebElement searchWrapper;

    // Step 2: Real input (appears after click)
    @FindBy(xpath = "//input[contains(@class,'SearchBarContainer__Input')]")
    private WebElement searchInput;

//    @FindBy(xpath = "//div[@role='button' and contains(@class,'tw-relative') and contains(@class,'tw-h-full')]")
//    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@role='button' and contains(@class,'tw-relative') and contains(@class,'tw-h-full')]")
    private List<WebElement> productCards;

    public SearchPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void searchProduct(String item){

        // Open search
        WaitUtil.getWait()
                .until(ExpectedConditions.elementToBeClickable(searchWrapper))
                .click();

        // Now input becomes visible
        WaitUtil.getWait()
                .until(ExpectedConditions.visibilityOf(searchInput))
                .sendKeys(item);
    }

    public void selectProductByName(String productName){

        WaitUtil.getWait()
                .until(ExpectedConditions.visibilityOfAllElements(productCards));

        System.out.println("productCards and its length--"+productCards+" "+productCards.size());

        for (WebElement product : productCards) {

            WebElement nameElement =
                    product.findElement(By.xpath(
                            ".//div[contains(@class,'tw-text-300')   and contains(@class,'tw-font-semibold')   and contains(@class,'tw-line-clamp-2')]"
                    ));
            System.out.println("getElement from grid-->"+nameElement.getText());
            String actualName = nameElement.getText().trim();

            if (actualName.toLowerCase().contains(productName.toLowerCase())) {
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
