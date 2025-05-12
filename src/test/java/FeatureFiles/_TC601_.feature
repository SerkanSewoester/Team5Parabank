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
      | firstName | lastName | Address        | City    | State | ZipCode | Phone          | SSN         | UserName   | Password | Confirm  |
       #| Olivia    | Bennett  | 849 Sunset Blvd  | Denver  | CO    | 80203   | (303) 555-6789 | 537-29-6481 | olivb801  | Pass123!   | Pass123!   |
      #| Ethan     | Carter   | 612 Maple Lane | Seattle | WA    | 98101   | (206) 555-2376 | 472-84-3159 | ethcar8910 | Eth@2025 | Eth@2025 |
      | Daniel    | Carter   | 742 Elm Avenue   | Austin  | TX    | 73301   | (512) 555-3746 | 483-65-2741 | dan_c89  | Tx!7rV2l9  | Tx!7rV2l9  |



