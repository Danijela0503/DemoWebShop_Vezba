package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest {

    RegisterPage registerPage;

    LoginPage loginPage;

    @BeforeMethod
    public void setLoginPage (){
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void logInUser (){
        registerPage.userRegistration();
        loginPage.logInAfterRegistration(registerPage.getEmailAddress(), registerPage.getPassword());

        Assert.assertTrue(loginPage.isUserLogin(), "User is not login");



    }
}
