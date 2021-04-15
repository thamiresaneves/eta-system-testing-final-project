@AirbnbSearch
Feature: As a user admin I want to search for a location so I can see all accommodation result

  @SearchForValidLocation
  Scenario: Search for a valid location should display 20 items per page
    Given  the search panel is being displayed
    When   fills the search field with "Recife"
    And    Clicks on button
    Then   A list with 20 accommodations should be displayed per page

  @SearchForChildrenAndBabies
  Scenario: Not possible to search just for babies or children
    Given the search panel is being displayed
    When the user clicks on guest option
    And  adds a baby
    Then the Adults should be incremented without allowing to remove it
    And removes a baby and an adult
    And adds a child
    Then the adults should be incremented without allowing to remove the adult

  @FlexibleDateSearch
  Scenario: Searching by flexible dates should display selected months
    Given the search panel is being displayed
    When fills the search field with "Recife"
    And clicks on the check in option
    And clicks on 'I am flexible' button
    And selects more than one month
    Then all months selected should be displayed