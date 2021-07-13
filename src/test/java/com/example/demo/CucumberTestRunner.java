package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Springboot-api-fresher-microservice/src/test/resources/features", glue = "src/test/java/com.example.demo.stepDefinition")
public class CucumberTestRunner {

}
