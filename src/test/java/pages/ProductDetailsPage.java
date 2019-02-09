package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private WebDriver driver;
    private static final By PRODUCT_TITLE = By.cssSelector("#title > span:first-of-type");
    private static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    private static final By ONE_CLICK_BUTTON = By.id("one-click-button");

    private static final By EBOOK_TITLE = By.id("ebooksProductTitle");

    public ProductDetailsPage(WebDriver driver){
        this.driver=driver;
    }

    public String getProductTitle(){
        return  driver.findElement(PRODUCT_TITLE)
                .getText();
    }

    public AddToCartConfirmPage addToCart(){
        if(driver.findElements(EBOOK_TITLE).size()>0)
        driver.findElement(ONE_CLICK_BUTTON).click();

        else{
            driver.findElement(ADD_TO_CART_BUTTON).click();
        }

        return new AddToCartConfirmPage(driver);
    }
}
