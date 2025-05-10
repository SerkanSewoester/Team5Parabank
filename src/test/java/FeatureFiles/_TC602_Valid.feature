Feature: Register Functionality

  @Accounts @Smoke @Regression
  Scenario: Register with valid user informations
    Given Navigate to the website
    When Enter valid username as "mia_le1" and password as "MiaFL2024!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

