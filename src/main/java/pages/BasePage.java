package pages;

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


}
