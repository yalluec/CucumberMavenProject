#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
Feature:Admin
  I want to use this template for my feature file

  @Smoke
  Scenario: Login with Valid credential
    Given User launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    When User enter email as "admin@yourstore.com" and password as "123adminn"
    When user click on login button
  #  Then user verify page title should be "Dashboard / nopCommerce administration"
    Then close browser
    

  @Sanity
  Scenario Outline: Login with Valid credential for multiple users
    Given User launch chrome browser
    When user opens url "https://admin-demo.nopcommerce.com/login"
    When User enter email as "<Email>" and password as "<Password>"
    When user click on login button
    Then user verify page title should be "Dashboard / nopCommerce administration"
    Then close browser
#
    Examples: 
      | Email                   | Password|
      |     admin@yourstore.com | admin   |
      |     admin123@yourstore.com| admin123   |
     
