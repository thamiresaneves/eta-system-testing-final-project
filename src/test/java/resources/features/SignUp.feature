@AirbnbSignUp
Feature: As a user admin I want to sign up using my phone number

  @SignUpWithPhoneField
  Scenario:
    Given  The user is be a host page
    When   Clicks on Comece já button
    And    Types a '' number
    And    Clicks on Continue button
    Then   The error message "O número de telefone é obrigatório." should be displayed