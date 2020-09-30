Feature: presence ui elements on Pages

  Scenario: Check, the presence of main elements on the Home Page
    Given User open the home page
    Then 4 images was displayed
    And  4 text was displayed below 4 Icons
    And Main title text center was displayed
    And Below main title text center was displayed

  Scenario: Check, presence  elements on the service page displayed
    Given Page opened
    And Pressed button with user icon
    And Entered text "epam" to the field "Login"
    And Entered text "1234" to the field "Password"
    And Pressed element with value 'Enter'
    When User opened through the header menu Service -> Different Elements Page
    Then Interface on Service page contain 4 checkboxes was displayed
    And  4 radios was displayed
    And Dropdown was displayed
    And 2 - buttons was displayed
    And Left section was displayed
    And Right section was displayed
