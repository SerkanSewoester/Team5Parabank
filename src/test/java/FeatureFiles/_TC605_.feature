Feature: Transfer between accounts

  Background:
    Given Navigate to the website
    When Enter valid username as "mia_le1" and password as "MiaFL2024!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

  @Payment @Regression
  Scenario: Send money between accounts
    Given Navigate to Transfer Funds page
    And Enter transfer information and submit
    And The user should be see the success message
    And The user navigates to Accounts Overview page
    And User confirms that the money transfer was successful

