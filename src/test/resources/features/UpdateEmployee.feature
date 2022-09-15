Feature: Update employees

  Scenario Outline: Update employee
    Given Update the new information for information of employee <name> and <job>
    Then The employee is updated succesfully
    Examples:
      | name          | job        |
      | Jorge Updated | Automation |