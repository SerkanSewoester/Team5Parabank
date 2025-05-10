Feature: Create account

  @Accounts @Smoke @Regression
  Scenario Outline: Creation of user record

    Given Navigate to website
    When  Click the register button
    And   User sending name,address,and other details in sign up
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | Address   | <Address>   |
      | City      | <City>      |
      | State     | <State>     |
      | ZipCode   | <ZipCode>   |
      | Phone     | <Phone>     |
      | SSN       | <SSN>       |
      | UserName  | <UserName>  |
      | Password  | <Password>  |
      | Confirm   | <Confirm>   |



    And  Click the register button in the registration
    Then Verify that user logged in


    Examples:
      | firstName | lastName | Address          | City    | State | ZipCode | Phone          | SSN         | UserName   | Password   | Confirm    |
      | Olivia    | Bennett  | 849 Sunset Blvd  | Denver  | CO    | 80203   | (303) 555-6789 | 537-29-6481 | olivb20250101  | Pass123!   | Pass123!   |
      | Ethan     | Carter   | 612 Maple Lane   | Seattle | WA    | 98101   | (206) 555-2376 | 472-84-3159 | ethcar8910   | Eth@2025   | Eth@2025   |
      | Mia       | Lewis    | 3912 Pine Street | Miami   | FL    | 33101   | (305) 555-9988 | 381-74-5293 | mia_lew33110 | MiaFL2024! | MiaFL2024! |



