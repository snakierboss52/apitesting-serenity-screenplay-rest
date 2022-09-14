Feature: Create employees

 Scenario Outline: Create employee
    Given The director fill the information need it to register a new employee like <name> and <job>
    Then The employee is created succesfully
   Examples:
      | name  | job                 |
      | Jorge | Automation Enginner |