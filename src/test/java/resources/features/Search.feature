@AirbnbSearch
Feature: As a user admin I want to search for a location so I can see all accommodation result

  @SearchForValidLocation
  Scenario:
    Given  The search panel is being displayed
    When   Fills the search field with "Recife"
    And    Clicks on search button
    Then   A list with 20 accommodations should be displayed per page

  @SearchForChildrenAndBabies
  Scenario: Not possible to search just for babies or children
    Given The search panel is being displayed
    When the user clicks on guest option
    And  adds a baby
    Then the Adults should be incremented without allowing to remove it
    And removes a baby and an adult
    And adds a child
    Then the adults should be incremented without allowing to remove the adult

  @ClearButton
  Scenario: Validation clear button is disabled on prices filter modal
    Given The search panel is being displayed
    When Fills the search field with "Recife"
    And Clicks on search button
    And Clicks on price button
    Then the clear button should be disabled
