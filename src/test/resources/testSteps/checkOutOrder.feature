@testing
Feature: Check out an order

    Scenario: using default payment option
      Given I'm a guest customer
      And I have a product in the cart
      And I'm on the checkout page
      When I provide billing details follow
        | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
        | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
      And I place an order
      Then the order should be placed successfully


  Scenario: share the state between steps (use data in 2nd step for 5th step) using Object + CustomDataTableType
    Given I'm a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And I have a product in the cart
    And I'm on the checkout page
    When I provide billing details at 2nd step
    And I place an order
    Then the order should be placed successfully