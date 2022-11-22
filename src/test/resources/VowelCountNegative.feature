Feature: Interview Exercise for Agile QA role
  Scenario: Should return null

    Given I provide invalid input
    | first  |
    | second |
    | third  |
    | forth  |
    | fifth  |
    When I am calling the application
    Then I expect no results