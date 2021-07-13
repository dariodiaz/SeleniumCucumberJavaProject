Feature: Test different actions on the Static Table page

Background: Navigate to Table web app.
  Given I navigate to the static table

@Test
Scenario: As a Test Engineer, I want to retrieve the value of an static table.
  Then I can return the value I wanted

@Test
Scenario: As a Test Engineer, I want to validate the static table is displayed.
  Then I can validate the table is displayed