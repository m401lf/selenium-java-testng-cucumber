@RegistrationDT
Feature: Verification of Registration functionality

  Background: common steps among scenarios
    Given I landed on an e-commerce website "https://tutorialsninja.com/demo/"
    And I can see page title "Your Store" and page url contains "tutorialsninja.com/demo/"
    And I can see the logo is displayed with "class" attribute equals "logo"
    And I click "Register" From My Account Dropdown options
    #When I navigate to account register page
    And I can see page title "Register Account" and page url contains "route=account/register"
    And "Register Account" header is displayed

  Scenario Outline:: should be able to registration with valid credentials
    And I can see "Your Personal Details" input sections
    And I can see "Your Password" section label
    And I input Your Personal Details and Your password sections with the following details:
      | FirstName | LastName | Telephone    | Password | Confirm-password |
      | Firstname | Lastname | 074000000000 | Password | Password         |
    And I input unique email address
    And I can see "Newsletter" input sections label
    And I tick on subscription option Yes
    And I click subscription "Yes" option
    And I can see Subscribe: "Yes" is ticked
    And I tick on "Privacy Policy" radio button
    And I tap on Continue button in account create page
    And I should see page title "<page-Title>" and url contains "<page-url>"
    Then I should see header text "<page-header>" and "<registerValidationMessage>" message
    And I tap on Continue button in Account success page
    And I should see page title "My Account" and page url contains "route=account/account" in account page
    And I tap on Edit account link
    And I can see page title "My Account Information" and url contains "?route=account/edit" in account edit page
    And I can see page heading "My Account Information" and personal details "Your Personal Details" in account edit page
    And I input a unique email address
    And I click Continue button in edit account page
    And I should see page title "My Account" and page url contains "account" in account page
    And I should see "Your account has been successfully updated" in account page
    And I tap on "Logout" link from Aside Widget
    And I should see page title "Account Logout" and page url contains "route=account/logout" in account logout page
    And click on "Continue" button
    And I am taken back to index page url "route=common/home" and page title as "Your Store"
    Examples:
      | page-Title                     | page-url               | page-header                    | registerValidationMessage |
      | Your Account Has Been Created! | ?route=account/success | Your Account Has Been Created! | Congratulations           |

  @verifyCompulsoryFields
  Scenario: Registration with blank - verify compulsory fields
    And I tap on Continue button in account create page
    Then I should see red warning error message "Warning: You must agree to the Privacy Policy!"
    And I can see "First Name must be between 1 and 32 characters!"
    And I should see "Last Name must be between 1 and 32 characters!"
    And "E-Mail Address does not appear to be valid!" is displayed
    And "Telephone" must be between "3" and "32" characters!
    And "Password" must be between "4" and "20" characters! is displayed
    And I should see 7 mandatory red icons

  @verifyCompulsoryFields
  Scenario: Registration with blank - verify compulsory fields
    And I tick on "Privacy Policy" radio button
    And I tap on Continue button in account create page
    And I can see "First Name must be between 1 and 32 characters!"
    And I should see "Last Name must be between 1 and 32 characters!"
    And "E-Mail Address does not appear to be valid!" is displayed
    And "Telephone" must be between "3" and "32" characters!
    And "Password" must be between "4" and "20" characters! is displayed
    And I should see 7 mandatory red icons
