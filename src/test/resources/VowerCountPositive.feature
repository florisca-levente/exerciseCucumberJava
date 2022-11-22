Feature: Interview Exercise for Agile QA role
Scenario: Count vowels and consonants

  Given I provide valid input
    | insert my text here |
  When I am calling the application
  Then I expect correct results
    | insert my text here | 5 | 11 |

  Given I provide valid input
    | foo              |
    | baz              |
    | some text        |
    | !@#$%^&*()_+-=őú |
  When I am calling the application
  Then I expect correct results
    | foo             | 2 | 1 |
    | baz             | 1 | 2 |
    | some text       | 3 | 5 |
    | !@#$%^&*()_+-=őú| 0 | 0 |