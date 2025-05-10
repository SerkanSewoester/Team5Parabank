Feature: Bill Payment Functionality

  Background:
    Given Navigate to the website
    When Enter valid username as "sophia_m94117" and password as "sophiapass1"
    And Click on LoginOrSign Up button
    Then SuccessMessage should be displayed

  @US603 @WaterBill @Regression @Smoke
  Scenario Outline: : User successfully pays a water bill
    Given The user navigates to the Bill Pay page
    When The user enters the following water bill details
      | billPayeeNameInput          | <Payee Name> |
      | pillPayeeAddressInput       | <Address>    |
      | billPayeeCityInput          | <City>       |
      | billPayeeStateInput         | <State>      |
      | billPayeeZipCodeInput       | <Zip Code>   |
      | billPayeePhoneNumberInput   | <Phone>      |
      | billPayeeAccountInput       | <Account No> |
      | billPayeeVerifyAccountInput | <Account No> |
      | billPayeeAmountInput        | <Amount>     |
    And The user confirms the payment
    Then A successful payment message and amount should be displayed
    And The user should see the "<Payee Name>", "<Amount>", in the transaction details

    And The user should verify that the account balance is updated in the account overview
    And The user should see the payment listed in the transaction history
    Examples:
      | Payee Name                 | Address            | City          | State      | Zip Code | Phone      | Account No | Amount |
      | Enerjisa Elektrik Faturasi | 742 Mission Street | San Francisco | California | 94103    | 4155550123 | 984321567  | 85     |
      | Iski Su Faturasi           | 2211 Post Street   | San Francisco | California | 94115    | 4158675309 | 782109345  | 45     |
      | IGDAS Dogalgaz Faturasi    | 580 Market Street  | San Francisco | California | 94104    | 4154447788 | 665432187  | 120    |
