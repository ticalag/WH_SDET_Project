$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/bet_placement.feature");
formatter.feature({
  "line": 2,
  "name": "Check bet placement",
  "description": "\r\nAs a end user\r\nI want to login\r\nso that I can start placing bets",
  "id": "check-bet-placement",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "User logs in and places a bet",
  "description": "",
  "id": "check-bet-placement;user-logs-in-and-places-a-bet",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "that I am on the sportsbook homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I log in",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "navigate to the \u003cselected\u003e event",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "place a \"\u003cvalue\u003e\" bet",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the bet should be successfully placed and the balance updated",
  "keyword": "Then "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "check-bet-placement;user-logs-in-and-places-a-bet;",
  "rows": [
    {
      "cells": [
        "value",
        "selected"
      ],
      "line": 20,
      "id": "check-bet-placement;user-logs-in-and-places-a-bet;;1"
    },
    {
      "cells": [
        "0.05",
        "Football"
      ],
      "line": 21,
      "id": "check-bet-placement;user-logs-in-and-places-a-bet;;2"
    },
    {
      "cells": [
        "0.25",
        "Tennis"
      ],
      "line": 22,
      "id": "check-bet-placement;user-logs-in-and-places-a-bet;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3860612294,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "User logs in and places a bet",
  "description": "",
  "id": "check-bet-placement;user-logs-in-and-places-a-bet;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "that I am on the sportsbook homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I log in",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "navigate to the Football event",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "place a \"0.05\" bet",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the bet should be successfully placed and the balance updated",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.that_I_am_on_the_sportsbook_homepage()"
});
formatter.result({
  "duration": 4431803555,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_log_in()"
});
formatter.result({
  "duration": 1695136993,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.navigate_to_Football_event()"
});
formatter.result({
  "duration": 688727162,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.05",
      "offset": 9
    }
  ],
  "location": "StepDefinition.place_a_bet(double)"
});
formatter.result({
  "duration": 1828403453,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.the_bet_should_be_successfully_placed_and_the_balance_updated()"
});
formatter.result({
  "duration": 57022559,
  "status": "passed"
});
formatter.after({
  "duration": 726682935,
  "status": "passed"
});
formatter.before({
  "duration": 3072914315,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "User logs in and places a bet",
  "description": "",
  "id": "check-bet-placement;user-logs-in-and-places-a-bet;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "that I am on the sportsbook homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I log in",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "navigate to the Tennis event",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "place a \"0.25\" bet",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the bet should be successfully placed and the balance updated",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.that_I_am_on_the_sportsbook_homepage()"
});
formatter.result({
  "duration": 4181003911,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_log_in()"
});
formatter.result({
  "duration": 1769631880,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.navigate_to_the_Tennis_event()"
});
formatter.result({
  "duration": 878378338,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.25",
      "offset": 9
    }
  ],
  "location": "StepDefinition.place_a_bet(double)"
});
formatter.result({
  "duration": 5428973860,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.the_bet_should_be_successfully_placed_and_the_balance_updated()"
});
formatter.result({
  "duration": 51696731,
  "status": "passed"
});
formatter.after({
  "duration": 695308152,
  "status": "passed"
});
});