@Functional
Feature: Login to Herokuapp
    Log in to Herokuapp 
  

  Background: Open the login page
    Given Herokuapp login page is opened
  
 @BasicTest
  Scenario Outline: Successful login Happy path
    When correct username "<p_Username>" is entered and correct password "<p_Password>" is entered
    And click on Login button
    Then I should find the Welcome message
    
	Examples:
	
  |p_Username | p_Password|
   |tomsmith   | SuperSecretPassword!|

    @SecurityTest
 		Scenario Outline: Unsuccessful login Security Test
    When incorrect username "<p_Username>" is entered and incorrect password "<p_Password>" is entered
    And click on Login button
    Then I should not find the Welcome message
    And reload the login page
    
	Examples:
	
  |p_Username | p_Password|
   |tom  | SuperS|
   |tomsmith | super|
