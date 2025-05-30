Feature:
 Scenario: Successful user registration with valid information
   Given user is on the home page
   Then verify that home page is visible
   Then user clicks on Sign up/Login button
   Then verify user is on the sign up page
   And user enter name and email address
   Then user clicks signup button