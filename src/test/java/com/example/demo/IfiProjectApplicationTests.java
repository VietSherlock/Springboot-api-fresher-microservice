package com.example.demo;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.stepDefinition.CustomerStepDefinition;

import io.cucumber.spring.CucumberContextConfiguration;
@CucumberContextConfiguration
@SpringBootTest(classes = {IfiProjectApplication.class, CucumberIntegrationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class IfiProjectApplicationTests {

}
