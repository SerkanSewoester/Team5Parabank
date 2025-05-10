Feature: Bill Pay Functionality

  @Payment @Smoke @Regression

  Scenario: Bill Pay for Electricity
    Given The user navigates to the ParaBank website
    When The user types username and password and clicks on the login button
    And The user clicks on the Bill Pay Button
    And The user types the name in the Payee Name box
    And The user fills in the Billing Information for the Electricity Bill
    Then The user should see the successful pay message
    And The user clicks on the Accounts Overview and account number
    And The user sees the transaction details and verifies that the information is correct