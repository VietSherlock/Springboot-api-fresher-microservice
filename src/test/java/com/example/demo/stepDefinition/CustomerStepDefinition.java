package com.example.demo.stepDefinition;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefinition {

	private HttpHeaders headers = new HttpHeaders();
	private String URI = "http://localhost:8081/customer/";
	private RestTemplate restTemplate = new RestTemplate();
	private ResponseEntity<String> response;

	@Given("^User Set POST customer service api endpoint$")
	public void setPostEndPoint() {
		System.out.println("POST URI: " + URI);
	}

	@When("^User Set request HEADER$")
	public void setRequestHeader() {
		headers.add("Accept", "appication/json");
		headers.add("Content-Type", "application/json");
	}

	@When("^User Send a POST HTTP request$")
	public void sendPostRequest() {

		String jsonBody = "{\"customerName\":\"Ngoc Viet\",\"phoneNumber\":\" 012345\"}";
		System.out.println("\n\n" + jsonBody);
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		// POST Method to ADD new customer

		response = restTemplate.postForEntity(URI, entity, String.class);
	}

	@Then("^User receive valid response$")
	public void verifyPostResponse() {
		String responseBody = "{\"id\":1,\"customerName\":\"Ngoc Viet\",\"phoneNumber\":\" 012345\"}";
        System.out.println("responseBody --->" + responseBody);
        assertThat(responseBody).isEqualTo(response.getBody());
	}

}
