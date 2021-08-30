@Products
Feature: Products Wishlist

  Scenario: Validate the product added to wishlist and cart
    Given  I add four different products to my wish list
    When  I view my wishlist table
    And  I find total 4 selected items in my Wishlist
    And  I search for lowest price product
    And  I am able to add the lowest price item to my cart
    Then  I am able to verify the item in my cart
