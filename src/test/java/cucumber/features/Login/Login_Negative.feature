@LoginNegative
Feature: Login Functionality

  Background: common steps
    Given I landed on an e-commerce page
    And navigate to Login page
    And I can see "New Customer" and "Returning Customer" sub headings texts
    And "Register Account" sub header is displayed

  Scenario Outline: User should NOT be able to login with invalid credentials: email address
    And I login in login page as a returning customer with unique email and password "<password>"
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"
    Examples:
      | password | loginValidationErrorMessage                           |
      | Password | Warning: No match for E-Mail Address and/or Password. |

  Scenario Outline: User should NOT be able to login with invalid credentials: password
    And I login in login page as a returning customer with valid email "<emailAddress>" and invalid password
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"
    Examples:
      | emailAddress       | loginValidationErrorMessage                           |
      | admin001@admin.com | Warning: No match for E-Mail Address and/or Password. |

  Scenario Outline: User should NOT be able to login with invalid credentials after 3 attempts
    And I login in login page as a returning customer
      | loginname                | password |
      | wrongUser@wrongemail.com | Password |
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"
    Examples:
      | loginValidationErrorMessage                                                                      |
      | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |
