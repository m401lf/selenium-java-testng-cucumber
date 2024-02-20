@Register
Feature: (TS_001) Register Functionality

  Scenario: I should be able to Register with valid credentials via registerOption
    Given I landed on an e-commerce website "https://tutorialsninja.com/demo/"
    And I can see page title "Your Store" and page url contains "tutorialsninja.com/demo/"
    And I can see the logo is displayed with "class" attribute equals "logo"
    And I click "Register" From My Account Dropdown options
    #When I navigate to account register page
    And I can see page title "Register Account" and page url contains "route=account/register"
    And "Register Account" header is displayed
    And I can see "Your Personal Details" input sections
    And I input firstName "FirstName"
    And I input lastName "LastName"
    And I input unique email address
    And I input telephone "074000000000"
    And I can see "Your Password" section label
    And I input password "password@123"
    And I input confirm password "password@123"
    And I can see "Newsletter" input sections label
    And I tick on subscription option Yes
    And I click subscription "Yes" option
    And I can see Subscribe: "Yes" is ticked
    And I tick on "Privacy Policy" radio button
    And I tap on Continue button in account create page
    And I should see page title "Your Account Has Been Created!" and url contains "?route=account/success"
    Then I should see header text "Your Account Has Been Created!" and "Congratulations" message
    And I tap on Continue button in Account success page
    And I should see page title "My Account" and page url contains "route=account/account" in account page
    And I tap on Edit account link
    And I can see page title "My Account Information" and url contains "?route=account/edit" in account edit page
    And I can see page heading "My Account Information" and personal details "Your Personal Details" in account edit page
    And I input a unique email address
    And I click Continue button in edit account page
    And I should see page title "My Account" and page url contains "account" in account page
    And I should see "Your account has been successfully updated" in account page
    And I tap on " Logoff" link from Aside Widget
    And I should see page title "Account Logout" and page url contains "logout" in account logout page
    And click on "Continue" button
    And I am taken back to index page url "route=common/home" and page title as "Your Store"

