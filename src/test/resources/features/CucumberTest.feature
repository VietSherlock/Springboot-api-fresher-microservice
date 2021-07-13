Feature: Test CRUD methods of Customer REST API

Scenario: Add Customer
		Given User Set POST customer service api endpoint
		When User Set request HEADER
		And User Send a POST HTTP request
		Then User receive valid response