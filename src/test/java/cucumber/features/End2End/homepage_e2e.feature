Feature: Verifying e-commerce HomePage to Order item functionality

  @Homepage_E2E
  Scenario: should be able to place an order
    Given I am on ecommerce website
    And I add products to cart "SKINSHEEN BRONZER STICK", "BENEFIT BELLA BAMBA" and "ABSOLUE EYE PRECIOUS CELLS"
    And I navigate to checkout-cart page
    And I increased quantity by 6
    And I reduced quantity by 2
    And I removed some items
    And I should see the product item , unit price, quantity and grand total price
    And I tap on checkout button
    And I can see "Returning Customer" and  "I am a new customer."
    And I login in login page as a returning customer
      | loginname       | password    |
      | datastudioplace | Manchester1 |
    #And I login with "datastudioplace" and "Manchester1" as a returning customer
    And I should be on checkout confirmation page
    And I click on confirm order button
    And I can see YOUR ORDER HAS BEEN PROCESSED is Displayed
    And I am presented with an order number "Your order #"
    And I click on continue Button
    And I am back to home page
