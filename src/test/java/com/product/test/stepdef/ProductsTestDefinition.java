package com.product.test.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcontext.TestContext;
import utils.PurchaseProducts;

public class ProductsTestDefinition {

    TestContext testContext;
    PurchaseProducts purchaseProducts;

    public ProductsTestDefinition(TestContext testContext) {
        this.testContext = testContext;
        purchaseProducts = new PurchaseProducts(testContext);
    }

    @Given("I add four different products to my wish list")
    public void productSelect() {
        purchaseProducts.launch();
        purchaseProducts.chooseMenu();
        purchaseProducts.addProductsWishList();
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {
        purchaseProducts.viewMyWishLists();
    }

    @And("^I find total (\\d+) selected items in my Wishlist$")
    public void iFindTotalFourSelectedItemsInMyWishlist(int count) {
        purchaseProducts.findMySelection(count);
    }

    @And("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {
        purchaseProducts.productPrice();
    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        purchaseProducts.addToCart();
    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {
        purchaseProducts.cart();
    }
}
