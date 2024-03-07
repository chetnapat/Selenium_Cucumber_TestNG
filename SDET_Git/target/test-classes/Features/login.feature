Feature: Login page automation for Sauce demo page

Background: 
Given user is on login page

  @smoke
  Scenario Outline: Check login functionality with valid users
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then user is navigated to home page
    And user close the browser

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |
      | problem_user  | secret_sauce |
