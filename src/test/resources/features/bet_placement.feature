
Feature: Check bet placement

  As a end user
  I want to login
  so that I can start placing bets

  Scenario Outline: User logs in and places a bet

    Given that I am on the sportsbook homepage

    When I log in

    And navigate to the <selected> event

    And place a "<value>" bet

    Then the bet should be successfully placed and the balance updated
    Examples:
      | value | selected |
      | 0.05  | Football |
      | 0.25  | Tennis   |









