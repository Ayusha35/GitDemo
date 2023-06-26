Feature: Verify addplace API

Scenario Outline: Verify if place is being added

Given  Add place payload with "<name>" "<language>" "<address>"
When   User calls "AddPlaceAPI" with "post" request
Then   API call got success with status code 200
And    "status" in response body is "OK"
And     "scope" in response body is "APP"
And    Verify place_Id created maps to "<name>" with "GetplaceAPI"

Examples:
|name|language|address|
|opera house|english|pune|
#|yak|french|sea cross center|