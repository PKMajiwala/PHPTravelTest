Feature: PHP Travel Newsletter subscription scenarios

  @Negative @Positive
  Scenario: Go to PHP Travel Login Page
    Given User is on PHPTravel website open

  Scenario Outline: User subscribes to nwesletter
    When User enters '<email>' in newsletter subscribtion email
    And Clicks on Subscribe button
    Then User checks the '<expected>' message

    Examples: 
      | email                | expected                            |
      |                      | The Email field is required.        |
      | asdasd               | Kindly Enter a Valid Email Address. |
      | pkmajiwala@gmail.com | Already Subscribed                  |
      | randomEmail          | Subscribed Successfully             |
