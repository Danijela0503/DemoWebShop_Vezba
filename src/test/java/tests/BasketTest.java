package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;

public class BasketTest extends BaseTest{


    BasketPage basketPage;

    @BeforeMethod()
    public void setBasketPage (){
        basketPage = new BasketPage(driver);
    }

    @Test
    public void addToBasket () throws InterruptedException {
        basketPage.addToBasket();
        Assert.assertTrue(basketPage.priceCheck());

    }
}
