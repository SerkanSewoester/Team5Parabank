Feature: Water Bill Payment

  Background:
    Given Navigate to the website
    When Enter valid username as "emma_h2025" and password as "emmapass1"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed
  @Payment @Regression @Smoke
  Scenario: User pays a water bill successfully
    When the user navigates to the Bill Pay page
    And the user fills in the water bill form with valid random data
    And the user submits the payment
    Then the payment confirmation should display the correct amount and account number
