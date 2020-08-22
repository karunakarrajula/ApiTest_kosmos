Feature: Health code

Scenario: Validating health parameter
	Given Navigate to api 
	When user calls "GetResults" with "GET" http requests
	Then API call get success with status codes 200
	And fetch "eula_b64" from "GetEula" with "GET" request
  