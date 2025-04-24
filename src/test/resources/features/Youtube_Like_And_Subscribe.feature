Feature: Youtube Like And Subscribe

  Background:
    Given The user is on the Youtube default page
    And The user is logged in to Google account

  @RegressionTest
  Scenario: Verifying video pause works correctly
    When The user performs the search request
    And The user clicks the video on 1 position
    And The user clicks Pause video button
    Then The video playing progress should be paused

  @SmokeTest @RegressionTest
  Scenario: Verifying like button submits correctly
    When The user performs the search request
    And The user clicks the video on 1 position
    And The user clicks the Like button
    Then The video like button should be pressed

  @SmokeTest @RegressionTest
  Scenario: Verifying subscribe button submits correctly
    When The user performs the search request
    And The user clicks the video on 3 position
    And The user clicks the Subscribe button
    Then The Subscribe button text should equals "Subscribed"

  @RegressionTest
  Scenario: Verifying subscription on channel page
    When The user performs the search request
    And The user clicks the video on 5 position
    And The user clicks the Subscribe button
    And The user opens the channel page in new tab
    Then The Subscribe button text should equals "Subscribed"