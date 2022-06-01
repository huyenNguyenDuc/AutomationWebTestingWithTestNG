@testing
Feature: Add to cart

  Rule: Add from Store page
    Background:
      Given I'm on the Store page

    Scenario: add product to cart using ParameterType to sharing data among step
      When I add a "Blue Shoes" to the cart
      Then I see 1 "Blue Shoes" in the cart

    Scenario: add product to cart by pressing Add to cart button
      Given I have already added one quantity
      When I press Add to Cart
      Then I see number of 2 quantity in the cart
      When I have already added quantities


#
#
#
#  Rule: Add from Product page
#    Background:
#      Given I'm on the Product page
#
#  Scenario Outline: add product to cart
#    When I add <quantity> <product_name> to the cart
#    Then I see <quantity> <product_name> in the cart
#    Examples:
#      | product_name | quantity |
#      | Blue Shoes   | 1        |
#      | Blue Shoes   | 2        |
#
#  Scenario: enter zero quantity
#    When I enter zero quantity
#    Then I see the warning message
#
#    Scenario Outline: press the arrow button
#      When I press <arrow_key> arrow
#      Then the quantity <status> by 1
#      Examples:
#        | arrow_key | status   |
#        | up        | increase |
#        | down      | decrease |

