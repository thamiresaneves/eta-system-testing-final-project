@AirbnbSearch
Feature: As a user admin I want to search for a location so I can see all accommodation result

  @SearchForValidLocation
  Scenario: Search for a valid location should display 20 items per page
    Given the search panel is being displayed
    When fills the search field with "Recife"
    And clicks on search button
    Then a list with 20 accommodations should be displayed per page

  @SearchForChildrenAndBabies
  Scenario: Not possible to search just for babies or children
    Given the search panel is being displayed
    When the user clicks on guest option
    And  adds a baby
    Then the adults should be incremented without allowing to remove it
    And removes a baby and an adult
    And adds a child
    Then the adults should be incremented without allowing to remove it

  @ClearButton
  Scenario: Validation clear button is disabled on prices filter modal
    Given the search panel is being displayed
    When fills the search field with "Recife"
    And clicks on search button
    And clicks on price button
    Then the clear button should be disabled

  @FlexibleDateSearch
  Scenario: Searching by flexible dates should display selected months
    Given the search panel is being displayed
    When fills the search field with "Recife"
    And clicks on the check in option
    And clicks on 'I am flexible' button
    And selects more than one month
    Then all months selected should be displayed

  @ClearFilters
  Scenario: Clicking on 'Clear' inside filters modal should clear all filters
    Given the search panel is being displayed
    When fills the search field with "Recife"
    And clicks on search button
    When clicks on more filters button
    And adds a beds
    And adds a bathrooms
    And clicks on clear all button
    Then all filters applied should be cleared

  @CurrencyBehaviorInsideExperiences
  Scenario: Changing the currency should update values exhibition
    Given the search panel is being displayed
    When clicks on experiences
    And fills the search field with "João Pessoa"
    And clicks on search button
    And changes the currency
    Then the currency should be updated for the experiences prices and on the page footer

  @SearchForALocationWithoutExperiences
  Scenario: Searching for a place without experiences should display No Results message
    Given the search panel is being displayed
    When clicks on experiences
    And fills the search field with "Pyongyang"
    And clicks on search button
    Then the "No results found" message should be displayed

  @SaveOnlineExperience
  Scenario: Should not be possible to save an online experience without being logged into the site
    Given the search panel is being displayed
    When clicks on online experiences
    And clicking on the first experience
    And clicking on save button
    Then the login panel should be displayed
