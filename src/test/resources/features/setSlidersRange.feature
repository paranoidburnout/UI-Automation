Feature: When user move the sliders function on drag-and-drop Range

  Background:
    Given Page opened
    And Pressed button with user icon
    And Entered text "epam" to the field "Login"
    And Entered text "1234" to the field "Password"
    And Pressed element with value 'Enter'

  Scenario: Сheck the functionality of the left and right slider
    And Opened through the left menu Service -> Dates
    When User clicked on the left slider and drag it to 70
    And On the right slider and drag it to 80 user clicked
    Then The "left" slider has been successfully moved
    And The "right" slider has been successfully moved