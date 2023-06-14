Feature: Check home page and search page functionality

  Scenario: Check registration flow
    Given created email
    When fill in registration form on home page
    And submit registration form
    Then user is created

  Scenario: Add car to favorites and check favorites
    Given open home page
    When open tab with BU cars
    And add car to favorites
    Then added car is exist in user's favorites list

  Scenario: Search old car honda
    Given open home page
    When search car by using filer
    Then honda car is open

  Scenario: Check seller phone
    Given open home page
    When search random car by using filer
    And open car from search list
    Then mobile number is shows

  Scenario: Compare article tittle and article link name
    Given open home page
    When follow to the article page
    And open article
    Then title and link name of article are matched




