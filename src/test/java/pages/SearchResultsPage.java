package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    private WebDriver driver;
    private static final By FIRST_SEARCH_RESULT = By.xpath("//*[@id=\"result_0\"]/div/div/div/div[2]/div[1]/div[1]/a");

    public SearchResultsPage(WebDriver driver) {
        this.driver=driver;
    }


    public String getFirstResultTitle(){
        String result = driver.findElement(FIRST_SEARCH_RESULT)
                .getText();

        return result;
    }

    public ProductDetailsPage clickFristResultTitle(){
        driver.findElement(FIRST_SEARCH_RESULT)
                .click();

        return new ProductDetailsPage(driver);
    }
}
