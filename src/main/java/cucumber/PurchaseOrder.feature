@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given the user is on the landing page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
  
    Given logged in user name is "<userName>" and password is "<password>"
    When I add product "<productName>" to Cart
    And Checkout "<productName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | userName  								|  password		    |	productName |
      | dvbende@gmail.com | Learning@1234    | ADIDAS ORIGINAL | 
