Feature: Google Account Login

  @SmokeTest
  Scenario Outline: Verify successful user login with valid credentials
    Given The user is on the Google Account SignIn page
    When The user submits the valid email: "<Email>"
    And The user submits the valid password: "<Password>"
    Then The user should be logged in to the Google account with email: "<Email>"

    Examples:
      | Email                    | Password                    |
      | olegolegovuch3@gmail.com | lab6test                    |
#      | mepadav875@excederm.com  | dev_mepadav875@excederm.com |