Feature: feature to use waiting of page elements

  Scenario: Validate click on button
    Given Open DemoQA Dynamic Properties page
    When Click on button after 5 seconds
    Then Button is clickable

  @TestRun
  Scenario: Validate click on button enable after
    Given Open DemoQA Dynamic Properties page
    When Click on button after enable after 5 seconds
    Then Enable after button is enable

