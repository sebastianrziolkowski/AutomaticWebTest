package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


public class FirstTest {

    private static WebDriver driver;
    private static HomePage homePage;
    private String email = "autotest7171@outlook.com";
    private String password = "amazon123";


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Java\\Intellij Projects\\AutomaticWebTest\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testSignIn()
    {
        assert (homePage.navigationMenu()
                .logInto()
                .typeEmailPassword(email,password)
                .clickLoginButton()
                .navigationMenu()
                .VerifyAccountButton().contains("Hello, AutomaicTest"));
    }


    @Test
    public void AddingItemToCard(){
        SearchResultsPage searchResultsPage =
            homePage.navigationMenu()
                    .logInto()
                    .typeEmailPassword(email,password)
                    .clickLoginButton()
                    .navigationMenu()
                    .searchFor("Books","C++");
        String itemTitle = searchResultsPage.getFirstResultTitle();
        ProductDetailsPage productDetailsPage =
                searchResultsPage.clickFristResultTitle();

        assert (productDetailsPage.getProductTitle().contains(itemTitle));

        AddToCartConfirmPage addToCartConfirmPage =
                productDetailsPage.addToCart();

        assert (addToCartConfirmPage.getConfirmText().equals("Added to Cart"));

        CartPage cartPage =
                addToCartConfirmPage.getNavigationMenu()
                .navigateToCartPage();

        assert (cartPage.getFirstItemText().contains(itemTitle));

        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

}
