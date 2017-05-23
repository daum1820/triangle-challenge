Feature: Server's Health Check
  Scenario: Server is OK
    When the client calls http://localhost:8080/tradeshift/health
    Then the response status is 200
    And the response body must contain OK

