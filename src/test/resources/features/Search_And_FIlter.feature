Feature: Search And Filter

  Background:
    Given The user is on the Youtube default page

  @SmokeTest
  Scenario Outline: Verifying search results response matches the search request
    When The user enters the search request: "<Search Request>"
    And The user submits the search request
    Then The search input on results page should equals search request: "<Search Request>"

    Examples:
      | Search Request                    |
      | Java Testing with Selenium Course |
      | Postman API Test Automation       |