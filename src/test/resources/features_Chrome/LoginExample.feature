#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Validate the Features of POST

  Scenario Outline: Validate the Errors of StoreNumber Field while doing a POST
    Given That user is in LoginPage
  	Then Verify that the Title "OrangeHRM" matches with it
    And login with the "Admin" and "admin123"
    Then Verify that you are in Homepage 
    
	Examples:

| username | password | title |

| Rob      | xyz1      | title1 |


    
    
    Scenario Outline: Validate the Errors of StoreNumber Field while doing a POST
    Given That user is in LoginPage
  	Then Verify that the Title "OrangeHRM" matches with it
    And login with the "Admin" and "admin123"  
    Then Verify that you are in Homepage 
    
	Examples:

| username | password | title |

| Rob      | xyz1      | title1 |

