$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/timeline.feature");
formatter.feature({
  "line": 1,
  "name": "Timeline display and ordering of updates",
  "description": "",
  "id": "timeline-display-and-ordering-of-updates",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Timeline Display order",
  "description": "",
  "id": "timeline-display-and-ordering-of-updates;timeline-display-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Timeline has atleast 10 updates",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Timeline is initialized by consumer",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "timeline should be loaded with 10 items in descending order of time when they were created",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 21
    }
  ],
  "location": "TimelineDisplayStepDefinition.timeline_has_atleast_updates(int)"
});
formatter.result({
  "duration": 701847527,
  "status": "passed"
});
formatter.match({
  "location": "TimelineDisplayStepDefinition.timeline_is_initialized_by_consumer()"
});
formatter.result({
  "duration": 32367296,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 31
    }
  ],
  "location": "TimelineDisplayStepDefinition.timeline_should_be_loaded_with_items_in_descending_order_of_time_when_they_were_created(int)"
});
formatter.result({
  "duration": 240528,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Consumer requests to fetch more items",
  "description": "",
  "id": "timeline-display-and-ordering-of-updates;consumer-requests-to-fetch-more-items",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Database has more then 20 posts and timeline has been initialized",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "consumer requests more items using fetchItem",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Timeline should be loaded with 10 more items And total item count should be 20",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 23
    }
  ],
  "location": "TimelineDisplayStepDefinition.database_has_more_then_posts_and_timeline_has_been_initialized(int)"
});
formatter.result({
  "duration": 21543913,
  "status": "passed"
});
formatter.match({
  "location": "TimelineDisplayStepDefinition.consumer_requests_more_items_using_fetchItem()"
});
formatter.result({
  "duration": 3219499,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 31
    },
    {
      "val": "20",
      "offset": 76
    }
  ],
  "location": "TimelineDisplayStepDefinition.timeline_should_be_loaded_with_more_items_And_total_item_count_should_be(int,int)"
});
formatter.result({
  "duration": 163046,
  "status": "passed"
});
});