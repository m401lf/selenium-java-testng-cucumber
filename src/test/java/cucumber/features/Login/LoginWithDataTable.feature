@LoginWithDataTable
Feature: Login Page - Login Functionality

  Background: common steps in scenarios
    Given I landed on an e-commerce page
    And navigate to Login page
    And I can see "New Customer" and "Returning Customer" sub headings texts
    And "Register Account" sub header is displayed
    And I can see aside widget labels count as "13" first label "Login" and last "Newsletter"

  Scenario Outline: should be able to login with valid credentials
    And I login in login page as a returning customer
      | loginname          | password |
      | admin001@admin.com | Password |
    And I click on Login button
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I tap on Your Edit Account Information link in aside widget
    And Updated account information excluding email with the following details below:
      | James | Bond | 213-233-3340 |
    And click edit account Continue button
    And I should see confirmation message "Success: Your account has been successfully updated."
    When I clicks on Logout link in aside Widget
    And "Account Logout" text is displayed
    And I tap logout Continue Button
    And back to index page title as "Your Store"

    Examples:
      | loginValidationMessage |
      | My Account             |

  Scenario Outline: should not be able to login with invalid credentials
    And I login in login page as a returning customer
      | loginname          | password      |
      | datastudioplace001 | Manchester001 |
    And I click on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"
    And back to login page title as "Account Login"

    Examples:
      | loginValidationErrorMessage |
      | Warning:                    |

