package pages;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class RegisterPage extends BasePage{

    private By registerLink = By.cssSelector(".header-links>ul>li>a[class='ico-register']");
    private By gender = By.xpath("//label[text()='Male']");
    private By firstNameField = By.cssSelector(".inputs>label[for='FirstName'] + input");
    private By lastNameField = By.xpath("//div/label[@for='LastName']/following-sibling::input");
    private By emailField = By.xpath("//input[@id='Email']");

    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successTextRegistration = By.cssSelector("div[class='result']");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker(new Locale("en-US"));

    String emailAddress = faker.internet().emailAddress();
    String password = faker.internet().password(6,10, true, true,
            true);

    public void userRegistration (){
        clickOnElement(registerLink);
        clickOnElement(gender);
        typeIn(firstNameField, faker.name().firstName());
        typeIn(lastNameField, faker.name().lastName());
        typeIn(emailField, emailAddress);
        typeIn(passwordField,password);
        typeIn(confirmPasswordField, password);
        clickOnElement(registerButton);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUserRegistered (){
        return matchesExpectedText(successTextRegistration, "Your registration completed");
    }
}
