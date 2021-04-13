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

  @SubmitAccommodationWithoutLocation
  Scenario: Ensure it is not possible to publish an accommodation without informing the type
    Given the user is on the be a host page
    When he logs into the application
    And he clicks on 'Become a host' button
    And clicks on 'Get Started' button
    And clicks on 'Continue' button
    And clicks on 'next' button
    Then the messages "Please select an option" and "You need to complete the fields to progress forward" should be displayed