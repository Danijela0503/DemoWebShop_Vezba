package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class LoginPage extends BasePage{

    By logoutButton= By.cssSelector(".ico-logout");
    By loginHeaderButton = By.cssSelector(".ico-login");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton= By.cssSelector("input[value='Log in']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logInAfterRegistration (String emailAddress, String password){
        clickOnElement(logoutButton);
        clickOnElement(loginHeaderButton);
        typeIn(emailField,emailAddress);
        typeIn(passwordField,password);
        clickOnElement(loginButton);
    }


    public boolean isUserLogin (){
        return matchesExpectedText(logoutButton, "Log out");
    }


}
