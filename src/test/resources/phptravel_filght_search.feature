Feature: PHPTravel Flight Search Automation test suite

  @Negative @Positive
  Scenario: Go to PHP Travel Login Page
    Given User is on PHPTravel website open

  @Positive
  Scenario: Apply Search Filter and Go to Search result page
    When User Clicks on Flights filter button
    Then Clicks on search button with applied filters

  @Positive
  Scenario Outline: Apply Stop filter and validate results
    When Clicks on '<filter>' Route Stops filter
    Then Validate results are according to '<filterData>' search result as per 'Route'

    Examples: 
      | filter | filterData |
      | 1 Stop |          1 |
      | 2 Stop |          2 |
      | 3 Stop |          3 |

  #There is no functionality of clear filter so reloading page
  @Positive
  Scenario Outline: User appluies flight aitlines filter and validate results
    Given User reloads page
    When Clicks on '<filter>' Airlines filter
    Then Validate results are according to '<filter>' search result as per 'Route'

    Examples: 
      | filter          |
      | United Airlines |
      | Wizz Air        |
