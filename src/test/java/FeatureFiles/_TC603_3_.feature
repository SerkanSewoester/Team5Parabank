Feature: Bill Payment Functionality

  Background:
    Given Navigate to ParaBank
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a Payment

    Given Navigate to Bill Pay
    When Enter credentials and click Send Payment
    Then User completed the bill payment successfully
    And  User see payment details click Accounts Overview amount
