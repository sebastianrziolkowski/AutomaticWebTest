package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    WebDriver driver;
    private static final By EMAIL_INPUT = By.id("ap_email");
    private static final By PASSWORD_INPUT = By.id("ap_password");
    private static final By SIGN_IN_BUTTON = By.id("signInSubmit");



    public SignInPage(WebDriver driver) {
    this.driver=driver;
    }


    public SignInPage typeEmailPassword(String email, String password)
    {
        driver.findElement(EMAIL_INPUT)
                .sendKeys(email);

        driver.findElement(PASSWORD_INPUT)
                .sendKeys(password);

        return new SignInPage(driver);
    }

    public HomePage clickLoginButton()
    {
        driver.findElement(SIGN_IN_BUTTON)
                .click();
        return new HomePage(driver);
    }
}
