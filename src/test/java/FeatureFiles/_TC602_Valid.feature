Feature: Register Functionality

  @Accounts @Smoke @Regression
  Scenario: Register with valid user informations
    Given Navigate to the website
    When Enter valid username as "olivb2025" and password as "Pass123!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

