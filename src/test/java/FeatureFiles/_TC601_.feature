Feature: Create account

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
      | firstName | lastName | Address           | City      | State | ZipCode | Phone          | SSN         | UserName   | Password  | Confirm   |
      | Jack      | Miller   | 492 Elmwood Dr    | Austin    | TX    | 73301   | (512) 342-8989 | 452-67-9812 | jackm123   | Team5.123 | Team5.123 |
     ## | Emma      | Harrison | 1234 Highland Ave | San Diego | CA    | 92101   | (619) 555-1023 | 389-45-7721 | emma_h2025 | emmapass1 | emmapass1 |
     ## | Anna      | Davis    | 789 Willow Street | Chicago   | IL    | 60601   | (312) 666-7345 | 501-62-1348 | annad456   | anna456   | anna456   |

