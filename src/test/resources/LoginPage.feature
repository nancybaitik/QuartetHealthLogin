Feature: Quartet Health Login Page
    # for cucumber we need to use Gherkin language
    # Feature file starts with Feature: keyword
    # for every test cases we create the Scenario
    # We need to write the java code inside StepDefinitions

  Background: Navigating to Quartet Login Page
     When user goes to Login Page
     Then user validates the title "Login - Quartet Health"
    And user validates Covid warning banner

 Scenario: Wrong username and wrong password
    When the user enters invalid username "brooklee@gmail.com" and invalid password "Hardtoquess"
    Then the user validates title after submit


    Scenario: Empty username and wrong password
      When the user lives blank username and enters invalid password "Mypassword"
      Then the user validates error message


      Scenario: Empty username and empty password
        Then the user doesn't enter any username and any password
        And the user validates error message


      Scenario: Show and hide password
         Given the user validates the encryption


      Scenario: Reset Password
        Given the user validates the forgot password function


        Scenario: Validate ENTER key to submit
          When the user enters invalid username, invalid password and clicks ENTER key


      Scenario Outline: User enters wrong username and wrong password
        Then the user enters invalid "<username>" and invalid "<password>"
        And  the user validates message and title
        Examples:
          | username                             | password                   |
          | brooklee@gmail.com                   | hardtoquess                |
          | BROOKLEE@gmail.com                   | HARDTO-QUESS               |
          | 10101010@yahoo.com                   | 101010109                  |
          | #######@gmail.com                    | !!@%*&                     |
          | brooklee@gmail.com                   |                            |
          | brookismyfirstnameandleeismylastname | mypasswordistoohardtoguess |






