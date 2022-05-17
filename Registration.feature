Feature: Registration to application
Sign up to website automationpractice.com

#similar to @BeforeTest in TestNG .Executes once before each scenario
Background: 
Given user is on automationpractice homepage
Then initialize webdriver 

@SuccessRegistration
Scenario Outline: Registration success
Given user name is not yet registered
When user registers with the right details "<Emailid>" in the system
Then registration is successful

Examples:
|Emailid|
|b@abc.com|
|c@def.com|


#end of test1

@FailureRegistration
Scenario: Registration failure with name existing
Given user name is already registered
When user registers with the username
Then registration is unsuccessful