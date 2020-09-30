Feature: Authorization

  Scenario: Authorization using password and login
    Given Page opened
    When User pressed button with user icon
    And Type to input with name "Login" text: "epam"
    And Type to input with name "Password" text: "1234"
    And User pressed element with value 'Enter'
    Then PITER CHAILOVSKII is displayed


