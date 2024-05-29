

Feature: Adding the users to the list.
 
Scenario Outline: Add user
Given user is on reqres url
When user enters the "<name>" and "<job>"
And user hit the users API
Then users are added to list
 
Examples:
|name|job|
|smy|chef|
|luffy|Analyst|
