package com.tradeshift.challenge;

import com.tradeshift.challenge.models.PolygonSide;
import com.tradeshift.challenge.models.Triangle;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
public class TrianguleChallengeSuite {

    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity<String> response;
    private Triangle triangle;

    @Given("^an invalid Triangle$")
    public void invalidTriangle(){
        this.triangle = null;
    }

    @Given("^an triangle$")
    public void createTriangle(){
        this.triangle = new Triangle();
    }

    @Given("^an triangle without one side (.*),(.*)$")
    public void createTriangle(Integer sideOne, Integer sideTwo){
        this.triangle = new Triangle();
        this.triangle.getSides().add(new PolygonSide<>(sideOne));
        this.triangle.getSides().add(new PolygonSide<>(sideTwo));
    }

    @Given("^an triangle (.*),(.*),(.*)$")
    public void createTriangle(Integer sideOne, Integer sideTwo, Integer sideThree){
        this.triangle = new Triangle(sideOne, sideTwo, sideThree);
    }

    @When("^we try to check the triangle at (.*)$")
    public void whenCallTraingleCheck(String url) {
        this.response = this.restTemplate.postForEntity(url, this.triangle, String.class, new HashMap<>());
    }

    @Then("^the check status is (\\d+)$")
    public void theResponseStatusIs(int status) throws Throwable {
        Assert.assertEquals(status, response.getStatusCode().value());
    }

    @And("^the check body must contain (.+)$")
    public void theResponseBodyMustContainFieldWithValue(String value) throws Throwable {
        Assert.assertEquals(value, response.getBody());
    }
}
