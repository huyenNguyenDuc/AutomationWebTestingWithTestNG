Feature: Withdraw money
  Here is free-form text

  Rule: The account balance is sufficient
  Here is free-form text
    Scenario: Withdraw money is less than the account balance
    Here is free-form text
      Given my bank account balance is $1000
      When I withdraw $500
      Then the withdraw process should be successfully
      And the bank account balance should be $500

    Scenario Outline: Withdraw with outbound
      Given my bank account balance is $1000
      When I withdraw $<withdraw_money>
      Then the withdraw process should be successfully
      And the bank account balance should be $<balance_money>

      Examples:
      Here is free-form text
        | withdraw_money | balance_money |
        | 1000           | 0             |
        | 1              | 99            |

      Examples:
        | withdraw_money | balance_money |
        | 0              | 1000          |

  Rule: The account balance is not sufficient
  Here is free-form text
    Scenario: Withdraw money is more than the account balance
    Here is free-form text
      Given my bank account balance is $1000
      When I withdraw $1500
      Then the warning message should be shown
      And the withdraw process should be stopped
      And the below mess should be shown
      """
      Your account balance is not sufficient. Please enter other amount
      """
      And the bank account balance should be $1000

