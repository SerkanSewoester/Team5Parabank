Feature: Create new bank account


  Background:
    Given Navigate to the website
    When Enter valid username as "mia_le1" and password as "MiaFL2024!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

  @Accounts @Smoke @Regression
  Scenario Outline: Create new account
    Given Navigate to open new account page
    When Click user selects new account type as "<accountType>"
    And User clicks open new account button
    And User can see success message
    And User clicks on new account number

    Then The user must be able to verify the account number and "<type>" he has opened.

    Examples:
      | accountType | type     |
      | CHECKING    | CHECKING |
     # | SAVINGS     | SAVINGS  |


