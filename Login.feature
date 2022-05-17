Feature: Login to advantageonlineshopping

  Scenario: Successful login
    Given user is on home page
    When user navigates to login page
    When user enters correct "<Username>" and "<Password>"
    Then login is successful

    #Examples:
    #|Username |Password|
    #|Test1000 |Test123 |
    #|Test1001 |Test123 | 