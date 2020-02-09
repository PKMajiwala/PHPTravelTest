Feature: PHPTravel Website Testing

  @Negative @Positive
  Scenario: Go to PHP Travel Login Page
    Given User is on PHPTravel website open
    When User clicks on Suppier Sign I page
    Then User should be able to see login page

  @Negative
  Scenario Outline: Login Page Login scenarios testing
    When User enters '<email>' in email
    And User enters '<password>' in password
    And Clicks on Login button
    Then User should be able to see error

    Examples: 
      | email                  | password      |
      | admin                  |               |
      |                        | admin         |
      | pkmajiwala@gmail.com   | asdasdasd     |
      | pkmajiwala@gmail.commm | asdasdasadssa |
      | pkmajiwala@gmail.com   |               |