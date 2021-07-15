Feature: Test CRUD methods of Customer REST API

Scenario: POST Customer
		Given User Set POST customer service api endpoint
		When User Set request HEADER
		And User Send a POST HTTP request
		Then User receive POST valid response
		And User receive POST status code 201
		
Scenario: GET Customer
		When User send a GET HTTP request
		Then User receive GET valid response
		And User receive GET status code 200 

Scenario: PUT Customer
		When User set PUT request HEADER
		And User send a PUT HTTP request
		Then User receive PUT valid response
		And User receive PUT status code 201
		
Scenario: DELETE Customer
		Given User set DELETE customer endpoint
		When User send DELETE HTTP request
		Then User receive DELETE status code 200
		
		
		