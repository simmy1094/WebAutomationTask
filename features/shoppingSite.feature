@ShoppingSite

  Feature: Login to shopping site, view and add four items in wishlist and lowest price item in the cart

    Scenario: To Add and Verify the lowest price item in my cart

      Given I add four different products to my wishlist
      When I view my wishlist table
      Then I find total four selected items in my Wishlist
      When I search for lowest price product
      And I am able to add the lowest price item to my cart
      Then I am able to verify the item in my cart
