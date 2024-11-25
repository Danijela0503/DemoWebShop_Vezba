package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {


    RegisterPage registerPage;

    @BeforeMethod
    public void setRegisterPage() {
        registerPage = new RegisterPage(driver);
    }


    @Test
    public void userRegistration() {
        registerPage.userRegistration();
        Assert.assertTrue(registerPage.isUserRegistered(), "User is not registered!");
    }


}

