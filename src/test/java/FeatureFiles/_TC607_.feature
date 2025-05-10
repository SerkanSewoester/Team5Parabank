Feature: Loan application Functionality

  Background:
    Given Navigate to the website
    When Enter valid username as "olivb2025" and password as "Pass123!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

  @Loan @Accounts @Regression
  Scenario Outline:
    Given The user navigates to the Request Loan page
    When The user enters the following water bill details
      | loanAmountInput  | <loanAmount>  |
      | downPaymentInput | <downPayment> |
    And The user apply the loan
    Then The user should see the Loan Request Result
    And The user navigates to Account Details page
    And The user should see the Account Type and Balance as "<loanAmount>"

    Examples:
      | loanAmount | downPayment |
      | 2000       | 400         |
      | 1000000    | 10000       |