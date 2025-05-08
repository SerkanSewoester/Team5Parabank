Feature: Create new bank account

  Scenario Outline: Create new account

    Given Navigate to open new account page
    When Click user selects new account type as "<accountType>"
    And User clicks open new account button
    And User can see success message
    And User clicks on new account number

    Then The user must be able to verify the account number and type he has opened.

    Examples:
      | accountType |
      | CHECKING    |
      | SAVINGS     |







