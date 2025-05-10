Feature: Login Functionality

  @Accounts @Smoke @Regression
  Scenario Outline: Login with invalid username and password
    Given Navigate to the website
    When Enter invalid username as "<username>" and password as "<password>"
    And Click on LoginOrSign Up button
    Then Error message should be displayed as "<error_message>"

    Examples:
      | username    | password        | error_message|
      | invaliduser | invalidpassword | The username and password could not be verified. |
      | invaliduser |                 | Please enter a username and password. |
      |             | invalidpassword | Please enter a username and password. |
      |             |                 | Please enter a username and password. |