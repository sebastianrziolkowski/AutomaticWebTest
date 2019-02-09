package pages;

import components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartConfirmPage {

    private WebDriver driver;
    private final NavigationMenu navigationMenu;
    private static final By CONFIRM_ITEM_TEXT = By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1");

    public AddToCartConfirmPage(WebDriver driver){
        this.driver=driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public NavigationMenu getNavigationMenu() {
        return navigationMenu;
    }

    public String getConfirmText(){
        return driver.findElement(CONFIRM_ITEM_TEXT)
                .getText();
    }
}
