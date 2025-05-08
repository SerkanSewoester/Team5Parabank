Feature: Register Functionality
  Scenario: Register with valid user informations
    Given Navigate to the website
    When Enter valid username as "jackm123" and password as "Team5.123"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

