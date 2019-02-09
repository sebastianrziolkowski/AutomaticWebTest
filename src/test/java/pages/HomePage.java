package pages;

import components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

    private WebDriver driver;
    private final String AMAZON_HOME_PAGE = "https://www.amazon.com/";
    private final NavigationMenu navigationMenu;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public HomePage open(){
        driver.get(AMAZON_HOME_PAGE);
        return this;
    }


    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

}
