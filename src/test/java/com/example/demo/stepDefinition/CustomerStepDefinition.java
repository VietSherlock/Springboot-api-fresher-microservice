package com.example.demo.stepDefinition;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

//@CucumberContextConfiguration
public class CustomerStepDefinition {

	private HttpHeaders headers;
	private String URI = "http://localhost:8082/customer/";
	private RestTemplate restTemplate = new RestTemplate();
	private ResponseEntity<String> response;

	//==========Definition steps of POST method===============//
	
	@Given("User Set POST customer service api endpoint")
	public void setPostEndPoint() {
		
		System.out.println("POST URL: " + URI);
		
	}

	@When("User Set request HEADER")
	public void setRequestHeader() {
		
		headers = new HttpHeaders();
//		headers.add("Accept", "appication/json");		//customer tra ve khong duoi dang json
		headers.add("Content-Type", "application/json");
	}

	@And("User Send a POST HTTP request")
	public void sendPostRequest() {

		String jsonBody = "{\"customerName\":\"Ngoc Viet\",\"phoneNumber\":\"012345\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);	
		System.out.println(headers);
		response = restTemplate.postForEntity(URI, entity, String.class);
	}

	@Then("User receive POST valid response")
	public void receiveValidResponse() {
		
		String responseBody = "{\"customerID\":1,\"customerName\":\"Ngoc Viet\",\"phoneNumber\":\"012345\",\"invoices\":null}";
        System.out.println("responseBody : " + responseBody);
        assertThat(responseBody).isEqualTo(response.getBody());
        
	}
	
	@And("User receive POST status code {int}")
	public void receiveStatusCode(int statusCode) {
		
		assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
		
	}
	
	//==========Definition steps of GET method===============//
	@When("User send a GET HTTP request")
	public void sendGetRequest() {
		response = (new RestTemplate()).getForEntity(URI, String.class);
	}
	
	@Then("User receive GET valid response")
	public void receiveGetValidResponse() {
		String responseBody = "{\"customerID\":1,\"customerName\":\"Ngoc Viet\",\"phoneNumber\":\"012345\",\"invoices\":null}";
		assertThat(responseBody).isEqualTo(response.getBody());
	}
	
	@And("User receive GET status code {int}")
	public void receiveGetStatusCode(int statusCode) {
		assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
	}
	
	
}
