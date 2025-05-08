Feature: Water Bill Payment

  @Payment @Regression @Smoke
  Scenario: User pays a water bill successfully
    Given the user is logged into the Para Bank website
    When the user navigates to the Bill Pay page
    And the user fills in the water bill form with valid random data
    And the user submits the payment
    Then the payment confirmation should display the correct amount and account number
