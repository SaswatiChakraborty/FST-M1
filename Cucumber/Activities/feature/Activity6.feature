@activity6
Feature: DataTable Test

  Scenario: Testing the todo loop
    Given User is ToDo list page
    When User enters the following task
    |task1|
    |task2|
    |task3|
    Then taks are added