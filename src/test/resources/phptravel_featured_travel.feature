Feature: PHPTravel Featured Travel Automation test suite

  @Negative @Positive
  Scenario: Go to PHP Travel Login Page and open featured travel
    Given User is on PHPTravel website open
    When User clicks on any of the featured travel option

  Scenario Outline: User validates social media sharing options
    When User clicks on '<media>' link
    Then User should able to jump on '<media>' link

    Examples: 
      | media    |
      | facebook |
      | whatsapp |

  Scenario: Validation of booking options
    When User books for '3' adults
    And '2' Childs
    And '6' Infrants
    Then Validate total amount

  Scenario: User books featured travel
    When User clicks on Book Now button
    And Clicks on Sign In button
    When User enters pkmajiwala@gmail.com in email
    And User enters vH62d9pE in password
    And Click on Confirm Booking option
