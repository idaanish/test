@users
Feature: Adding the users1 to the list
 
Background: 
Given user1 is on reqres URL

@add
Scenario Outline: Add users1
#Given user1 is on reqres URL
When user1 enters the "<name>" and "<job>"
And user1 hit the users API
Then users1 are added to list
 
Examples:
|name|job|
|smy|analyst|
|luffy|developer|


@update
Scenario:update the user1
#Given user1 is on reqres URL
When user1 enters name and job
|head|cricketer|
|cumminus|auscaptain|
And user1 click the the api
Then user data is updated

