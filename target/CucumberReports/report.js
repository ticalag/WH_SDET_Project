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
  "duration": 6629912245,
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
  "duration": 16543315675,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_log_in()"
});
formatter.result({
  "duration": 6116179370,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.navigate_to_Football_event()"
});
formatter.result({
  "duration": 3119481235,
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
  "duration": 4710751218,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.the_bet_should_be_successfully_placed_and_the_balance_updated()"
});
formatter.result({
  "duration": 1198353116,
  "status": "passed"
});
formatter.after({
  "duration": 7900524957,
  "status": "passed"
});
formatter.before({
  "duration": 3816762142,
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
  "duration": 20516738822,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_log_in()"
});
formatter.result({
  "duration": 8105815354,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.navigate_to_the_Tennis_event()"
});
formatter.result({
  "duration": 4432229651,
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
  "duration": 6812059934,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.the_bet_should_be_successfully_placed_and_the_balance_updated()"
});
formatter.result({
  "duration": 6138409232,
  "status": "passed"
});
formatter.after({
  "duration": 2212118776,
  "status": "passed"
});
});