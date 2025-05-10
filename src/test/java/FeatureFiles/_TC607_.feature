Feature: Loan application Functionality

  Background:
    Given Navigate to the website
    When Enter valid username as "mia_lew08" and password as "MiaFL2024!"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

  @Loan @Accounts @Regression
  Scenario Outline:User applies for a loan with different amounts and down payments
    Given The user navigates to the Request Loan page
    When The user enters the following water bill details
      | loanAmountInput  | <loanAmount>  |
      | downPaymentInput | <downPayment> |


    Examples:
      | loanAmount | downPayment |
      | 2000       | 400         |
      | 1000000    | 10000       |