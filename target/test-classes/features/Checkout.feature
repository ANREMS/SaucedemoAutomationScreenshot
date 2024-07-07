@Checkout
Feature: Checkout
  User checkout items from cart

  @positive
  Scenario: Checkout item from cart
    #Login
    Given User already open the website sauce demo
    When User input "standard_user" as username "secret_sauce" as password
    #Filter z to a
    And User filters the list of product by text "Name (Z to A)"
    #Adding Item
    And User clicking "Test.allTheThings() T-Shirt (Red)" of item into a cart
    And User clicking "Sauce Labs Onesie" of item into a cart
    #Going to cart page
    And User navigating to cart page
    #Verifying user on cart page
    Then User already on "Your Cart" as cart page
    #Removing 1 item from cart
    When User remove first item in cart
    #Going to checkout page
    And User navigating to checkout page
    #Input firstName lastName and postalCode
    And User filling "Studentfn" as firstName, "Studentln" as lastName and "IG11AB" as postal code
    #Going to receipt page
    And User navigating to checkout overview page
    #VerifyingPayment
    Then User verifying item total and tax price
    #Pay and back to homePage
    And User navigating to checkout complete page and going back to home page