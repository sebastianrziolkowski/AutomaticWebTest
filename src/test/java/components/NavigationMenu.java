package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;

public class NavigationMenu {

    private WebDriver driver;
    private final By SEARCH_DROPDOWN_BOX = By.id("searchDropdownBox");
    private final By SEARCH_INPUT = By.id("twotabsearchtextbox");
    private final By SEARCH_GO_BUTTON = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private final By NAVIGATION_ITEM_CART = By.id("nav-cart");
    private final By LOGIN_BUTTON = By.id("nav-link-accountList");
    private final By ACCOUNT_BUTTON = By.cssSelector("#nav-link-accountList");
    private final By LOGOUT_BUTTON = By.cssSelector("#nav-item-signout > span");




    public NavigationMenu(WebDriver driver) {
        this.driver=driver;
    }


    public SearchResultsPage searchFor(String department, String itemToSearch){
        new Select(driver.findElement(SEARCH_DROPDOWN_BOX))
                .selectByVisibleText(department);

        driver.findElement(SEARCH_INPUT)
                .sendKeys(itemToSearch);

        driver.findElement(SEARCH_GO_BUTTON)
                .click();
        return new SearchResultsPage(driver);
    }

    public CartPage navigateToCartPage() {
        driver.findElement(NAVIGATION_ITEM_CART)
                .click();

        return new CartPage(driver);
    }


    public SignInPage logInto(){
        driver.findElement(LOGIN_BUTTON)
                .click();
        return new SignInPage(driver);
    }

    public HomePage logOut(){
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(ACCOUNT_BUTTON))
                .build()
                .perform();

        driver.findElement(LOGOUT_BUTTON)
                .click();

        HomePage homePage = new HomePage(driver);
        homePage.open();
        return homePage;
    }

    public String VerifyAccountButton()
    {
        return driver.findElement(ACCOUNT_BUTTON).getText();
    }
}
