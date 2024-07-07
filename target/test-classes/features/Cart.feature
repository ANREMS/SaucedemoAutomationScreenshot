@Cart
Feature: Cart Feature
  As a user i want to add or remove item from cart

  @positive
  Scenario: Adding item to cart
    Given User already open the website sauce demo
    When User input "standard_user" as username "secret_sauce" as password
    And User filters the list of product by text "Name (Z to A)"
    And User clicking "Test.allTheThings() T-Shirt (Red)" of item into a cart
    Then User clicking "Sauce Labs Onesie" of item into a cart

  @negative
  Scenario: Remove item from cart
    Given User input "standard_user" as username "secret_sauce" as password
    When User clicking "Test.allTheThings() T-Shirt (Red)" of item into a cart
    And User navigating to cart page
    Then User remove all item in cart
    
  @negative
  Scenario: Reset App state
		Given User input "standard_user" as username "secret_sauce" as password
		When User clicking "Test.allTheThings() T-Shirt (Red)" of item into a cart
		And User navigating to cart page
		Then User reset app state