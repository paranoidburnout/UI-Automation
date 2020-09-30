Feature: UI elements functionality

  Background:
    Given Page opened
    And Pressed button with user icon
    And Entered text "epam" to the field "Login"
    And Entered text "1234" to the field "Password"
    And Pressed element with value 'Enter'
    When User opened through the header menu Service -> Different Elements Page

  Scenario: Check in logs section selected values and status
    And Checkbox "Water" elements have been selected
    And Checkbox "Wind" elements have been selected
    And Radio "Selen" element has been selected
    And In dropdown Yellow element has been selected
    Then In logs panel "Water" status changed to "true"
    And Panel "Wind" status changed to "true" in logs
    And In logs panel "metals" value changed to "Bronze"
    And Panel "colors" value changed to "Yellow" in logs



