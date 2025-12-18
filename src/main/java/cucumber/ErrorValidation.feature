Feature: Error Validation for login page
  In order to ensure only registered users can log in
  As a user of the ecommerce site
  I want to see appropriate error messages when login fails
@ErrorValidation 
Scenario Outline:Positive test for submitting order
    Given the user is on the landing page
    When  logged in user name is "<userName>" and password is "<password>"
    Then  "Incorrect email or password." message is displayed
    
    
    Examples:
      | userName           | password        | productName|
      | dvbende@gmail.com  | Learning@12345   |ADIDAS ORIGINAL|
     