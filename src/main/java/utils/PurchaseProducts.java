package utils;

import io.cucumber.java.hu.De;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.DemoShop;
import testcontext.TestContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PurchaseProducts {

    TestContext testContext;
    DemoShop demoShop;
    private static final int ITEM_COUNT = 4;
    private int tableRow = 0;
    Properties prop = new Properties();

    public PurchaseProducts(TestContext testContext) {
        this.testContext = testContext;
        demoShop = new DemoShop(testContext);
    }

    public Properties prop() {
        try (InputStream input = new FileInputStream("application.properties")) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public void launch() {
        testContext.getDriver().get(prop().getProperty("url"));
    }

    public void chooseMenu() {
        demoShop.acceptAll().click();
        demoShop.shopMenu().click();
    }

    public void addProductsWishList() {
        try {
            String[] products = prop().getProperty("products").split(";");
            for (String product : products) {
                demoShop.addWishList(product).click();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void viewMyWishLists() {
        demoShop.viewWishList().click();
    }

    public void findMySelection(int expectedCount) {
        int productCounts = demoShop.wishListItems().size();
        Assert.assertEquals("WishList Product counts are not matched", expectedCount, productCounts);
    }

    public void productPrice() {
        double amount = 999.00;

        for (int i = 1; i <= ITEM_COUNT; i++) {
            String[] price = demoShop.itemPrice(i).getText().trim().split("£");
            double amount1 = Double.parseDouble(price[2]);
            if (amount1 < amount) {
                amount = amount1;
                tableRow = i;
            }

        }


    }

    public void addToCart(){
        demoShop.addToCart(tableRow).click();
    }

    public void cart(){
        try {
            Thread.sleep(1000);
            demoShop.cart().click();
            int actualItem = demoShop.productInCart().size();
            Assert.assertEquals("Cart items are not matched", 1, actualItem);
        }catch (InterruptedException e){
            e.getMessage();
        }
    }
}
