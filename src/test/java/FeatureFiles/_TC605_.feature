Feature: Transfer between accounts

  Background:
    Given Navigate to ParaBank
    When Enter username and password and click login button
    Then User should login successfully

  @Payment @Regression
  Scenario: Send money between accounts

    Given enter transfer information and submit
