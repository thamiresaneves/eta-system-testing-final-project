@AirbnbSearch
Feature: As a user admin I want to search for a location so I can see all accommodation result

  @SearchForValidLocation
  Scenario:
    Given  The search panel is being displayed
    When   Fills the search field with "Recife"
    And    Clicks on button
    Then   A list with 20 accommodations should be displayed per page
