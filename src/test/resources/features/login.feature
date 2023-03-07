@FIX10-260
Feature: Fidexio app login functionality
  User Story:
  As a user, I should be able to log in so that I can land on homepage.

  Accounts are: posManager, salesManager

Background: For the scenarios in the feature file, user is expected to be on login page
  Given user is on the login page

@FIX10-271
Scenario Outline: Verify user can log in with valid credentials
  When user enters username "<username>"
  And user enters password "<password>"
  And user clicks on the log in button
  Then user should see the inbox page
Examples:
  | username                | password     |
  | posmanager10@info.com   | posmanager   |
  | salesmanager10@info.com | salesmanager |

@FIX10-272
Scenario Outline: Verify 'Wrong login/password' is displayed for invalid credentials
  When user enters username "<username>"
  And user enters password "<password>"
  And user clicks on the log in button
  Then user should see the "Wrong login/password" message
Examples:
  | username                | password      |
  | wrongemail10@info.com   | wrongpassword |
  | wrongemail10@info.com   | salesmanager  |
  | salesmanager10@info.com | wrongpassword |

@FIX10-273
Scenario Outline: Verify 'Please fill out this field' is displayed for empty credentials
  When user enters username "<username>"
  And user enters password "<password>"
  And user clicks on the log in button
  Then user should see the alert
Examples:
  | username                | password     |
  |                         |              |
  | salesmanager15@info.com |              |
  |                         | salesmanager |

@FIX10-275
Scenario Outline: Verify the password is hidden by the use of bullets
  When user enters username "<username>"
  And user enters password "<password>"
  Then user should not be able to see the password
  Examples:
    | username                | password     |
    | posmanager10@info.com   | posmanager   |
    | salesmanager10@info.com | salesmanager |

@FIX10-276
Scenario Outline: Verify the 'Enter' key works correctly on the login page
  When user enters username "<username>"
  And user enters password "<password>"
  And user clicks on the enter key
  Then user should see the inbox page
  Examples:
    | username                | password     |
    | posmanager10@info.com   | posmanager   |
    | salesmanager10@info.com | salesmanager |