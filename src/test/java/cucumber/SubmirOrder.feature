
  Feature: Purchase the order from Ecommerce Website
    I want to use this template for my feature file

    Background:
      Given I landed on Ecommerce Page

      @Regression
    Scenario Outline: Positive Test of Submitting the order
      Given Logged in with username <name> and password <password>
      When I add product <productName> to Cart
      And Checkot <productName> and submit the order
      Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation

      Examples:
        | name                | password     | productName |
        | ismetp.27@gmail.com | 1453Istanbul | ZARA COAT 3 |
