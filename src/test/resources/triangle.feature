Feature: Triangle Suite

  Scenario: Triangle is NULL
    Given an invalid Triangle
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 500
    And the check body must contain Triangle must not be null

  Scenario: Triangle without sides
    Given an triangle
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 500
    And the check body must contain Triangle's sides must not be null

  Scenario: Triangle with less than 3 sides
    Given an triangle without one side 3,3
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 500
    And the check body must contain Triangle must have 3 sides

  Scenario: Triangle invalid side length
    Given an triangle 4,0,4
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 500
    And the check body must contain Triangle's side must be bigger than 0

  Scenario: Triangle inequality
    Given an triangle 10,3,4
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 500
    And the check body must contain This is a triangle inequality

  Scenario: Triangle EQUILATERAL
    Given an triangle 10,10,10
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 200
    And the check body must contain EQUILATERAL

  Scenario: Triangle ISOSCELES
    Given an triangle 10,10,7
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 200
    And the check body must contain ISOSCELES

  Scenario: Triangle SCALENE
    Given an triangle 10,7,5
    When we try to check the triangle at http://localhost:8080/tradeshift/triangle
    Then the check status is 200
    And the check body must contain SCALENE
