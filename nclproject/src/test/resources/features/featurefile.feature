Feature: Cruise search

  @cruise
  Scenario: Client filters cruises by destination and price
    Given clients searches for "Alaska Cruises" and April,2021
    And clicks on "find a cruise" button
    And sees a starting price on the first displayed cruise
    Then clicks on "view cruise" button
    And navigates to Dates & Prices section
    Then  at least one Category price should match the advertised price
