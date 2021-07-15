package com.example.demo;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.stepDefinition.CustomerStepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/features"})
@RunWith(Cucumber.class)
//@SpringBootTest(classes = CustomerStepDefinition.class)
public class CucumberIntegrationTest {

}
