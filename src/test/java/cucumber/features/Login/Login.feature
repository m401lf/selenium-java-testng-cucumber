@Login
Feature: Login Functionality

  Background: common steps
    Given I landed on an e-commerce page
    And navigate to Login page
    And I can see "New Customer" and "Returning Customer" sub headings texts
    And "Register Account" sub header is displayed

  Scenario Outline: user should be able to login with valid credentials
    And I login in login page as a returning customer
      | loginname          | password |
      | admin001@admin.com | Password |
    And I click on Login button
    Then should be presented with the following validation message as "<loginValidationMessage>"
    Examples:
      | loginValidationMessage |
      | My Account             |

#  Scenario Outline: User should NOT be able to login with invalid credentials after 3 attempts
#    And I login in login page as a returning customer
#      | loginname                | password |
#      | wrongUser@wrongemail.com | Password |
#    And I click on Login button
#    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
#    And back to login page title as "Account Login"
#    Examples:
#      | loginValidationErrorMessage                                                                      |
#      | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |

  Scenario Outline: User should NOT be able to login with invalid credentials
    And I login in login page as a returning customer with unique email and password "Password"
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"
    Examples:
      | loginValidationErrorMessage                           |
      | Warning: No match for E-Mail Address and/or Password. |

  Scenario Outline: User should NOT be able to login with invalid email credentials
    And I login in login page as a returning customer with email "<email>" and password "<password>"
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"
    Examples:
      | email           | password | loginValidationErrorMessage                           |
      | email@email.com | Password | Warning: No match for E-Mail Address and/or Password. |