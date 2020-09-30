Feature: 2 Service buttons functionality on Home Pages

  Background:
    Given Page opened

  Scenario: Check, presence Service in the header and options inside displayed
    When Clicked on Service in the header
    Then Drop down contains option in the header

  Scenario: Check, presence Service in the left and options inside displayed
    When Clicked on Service in the left
    Then Drop down contains option in the left
