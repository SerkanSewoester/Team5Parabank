Feature: Update Contact Info

  Background:
    Given Navigate to website ParaBank
    When Enter username and password
    Then should be login successfully

    @Contact @Accounts
  Scenario: Update user contact information
    Given Navigate to update contact info
    When User enters new valid data
    And User click on the update profile button
    Then User should be see the profile update message

  Scenario: Update user contact information negative
    Given Navigate to update contact info
    When User enters invalid data or empty profile field
    And User click on the update profile button
    Then User should be see the error message
