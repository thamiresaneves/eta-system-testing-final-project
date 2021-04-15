@AirbnbSignUp
Feature: As a user admin I want to sign up using my phone number

  @SignUpWithPhone
  Scenario Outline: Create a user with invalid phone numbers
    Given  the user is on the be a host page
    When   he clicks on 'Get started' button
    And    types a "<phone>" number
    And    clicks on 'Continue' button
    Then   The an "<error-message>" should be displayed
    Examples:
      | phone | error-message                                             |
      |       | Phone number is required.                                 |
      | 22    | Phone number is too short or contains invalid characters. |