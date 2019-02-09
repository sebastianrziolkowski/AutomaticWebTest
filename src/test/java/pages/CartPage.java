package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private static final By FIRST_CART_ITEM = By.cssSelector(".sc-list-body.sc-java-remote-feature > .sc-list-item:first-of-type .a-size-medium.sc-product-title.a-text-bold");   //test
    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    public String getFirstItemText(){
        return driver.findElement(FIRST_CART_ITEM)
                .getText();
    }
}
