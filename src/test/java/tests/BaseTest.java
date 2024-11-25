package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void initialSetUp (){
        driver = DriverManager.setUpDriver("Chrome");
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser (){
        driver.quit();
    }


}
