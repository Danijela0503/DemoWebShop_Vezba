package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private static final Logger log = LogManager.getLogger(BasePage.class.getName());

    protected WebElement getElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void typeIn (By locator, String text){
        getElement(locator).sendKeys(text);
    }

    protected void clickOnElement (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected String getText(By locator){
        return getElement(locator).getText();
    }

    protected boolean matchesExpectedText (By locator, String expectedText){
        return getText(locator).trim().equals(expectedText);
    }

    protected boolean matchesExpectedText1 (By locator, String expectedText){
        if(getText(locator).trim().equals(expectedText)){
            log.info("PASSED - Actual text: " + getText(locator) + ", is equal to expected text: " + expectedText);
            return true;
        }else {
            log.error("FAILED - Actual text: " + getText(locator) + ", is NOT equal to expected text: " + expectedText);
        }  return false;
    }


}
