package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testcontext.TestContext;

import java.util.List;

public class DemoShop extends BaseStep {

    public DemoShop(TestContext testContext) {
        super(testContext);
    }

    public WebElement acceptAll(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Accept all')]"));
    }

    public WebElement shopMenu() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Shop')]"));
    }

    public WebElement addWishList(String product) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'"+product+"')]/../../div/div[2]//div/div/a"));
    }

    public WebElement cart() {
        return waitForElementPresent(By.xpath("//*[@id=\"blog\"]/div[2]/div[1]/div/div/div[3]/div[1]/div/div/a/i"));
    }

    public WebElement viewWishList() {
        return waitForElementPresent(By.xpath("//*[@id='blog']/div[3]/div[1]/div/div/div[3]/div[3]/a/i"));
    }

    public List<WebElement> wishListItems() {
        return findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr"));
    }

    public WebElement itemPrice(int rows){
        return waitForElementPresent(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr["+rows+"]/td[4]"));
    }

    public WebElement addToCart(int rows){
        return waitForElementPresent(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr["+rows+"]/td[6]"));
    }

    // //table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr

    public List<WebElement> productInCart() {
        return findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr/td[@class='product-name']/a"));
    }


}
