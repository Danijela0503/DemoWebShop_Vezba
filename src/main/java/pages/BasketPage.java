package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class BasketPage extends BasePage {

    By headerMenuComputers = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By headerMenuNotebooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]");
    By headerMenuBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
    By addToCart = By.cssSelector("input[value='Add to cart']");
    By goToShoppingCart = By.cssSelector("#topcartlink>a[class='ico-cart']>span[class='cart-label']");
    By productListPrice = By.cssSelector(".product-subtotal");
    By totalPrice = By.cssSelector(".product-price>strong");


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger log = LogManager.getLogger(BasketPage.class.getName());

    public void hover(By locator, long wait) {
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .build()
                .perform();
    }

    public void hoverAndClick(By locator, long wait) {
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .click()
                .build()
                .perform();
    }

    public void clickOnRandomElement(By locator) {
        List<WebElement > list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    public void addToBasket() throws InterruptedException {
        Thread.sleep(1000);
        hover(headerMenuComputers, 3);
        hoverAndClick(headerMenuNotebooks, 1);
        clickOnElement(addToCart);
        hoverAndClick(headerMenuBooks, 1);
        clickOnRandomElement(addToCart);
        clickOnRandomElement(addToCart);
        clickOnElement(goToShoppingCart);

    }

    public boolean priceCheck() {
        List<WebElement> list = driver.findElements(productListPrice);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + Double.parseDouble(list.get(i).getText());
        }
        //System.out.println("Zbir cena u korpi je: " + sum);

        double total = Double.parseDouble(getElement(totalPrice).getText());
        //System.out.println("Total je: " + total);

        if (sum ==total){
            log.info("Sum of product: " + sum + ", is equal to total price: " +total);
            return true;
        } else {
            log.error("Sum of product: " + sum + ", is NOT equal to total price: " +total);
        }
        return false;

    }
}
