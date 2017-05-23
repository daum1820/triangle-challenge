package com.tradeshift.challenge;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;

@SpringBootTest(classes = TriangleChallengeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class HealthCheckSuite {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("^the client calls (.*)$")
    public void whenCallHealth(String url) {
        this.response = this.restTemplate.getForEntity(url, String.class, new HashMap<>());
    }

    @Then("^the response status is (\\d+)$")
    public void theResponseStatusIs(int status) throws Throwable {
        Assert.assertEquals(status, response.getStatusCode().value());
    }

    @And("^the response body must contain (.+)$")
    public void theResponseBodyMustContainFieldWithValue(String value) throws Throwable {
        Assert.assertEquals(value, response.getBody());
    }
}

