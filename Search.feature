Feature: Search
  
  @SmokeTest
  Scenario: Search Success Advantageonlineshopping
    Given I am in homepage
    When I enter a search keyword in the search box
    |Productname|
    |mice|
    |Tablet|
    |Laptop|
    Then I validate the outcomes
  
  