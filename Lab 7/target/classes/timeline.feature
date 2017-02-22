Feature: Timeline display and ordering of updates

  Scenario: Timeline Display order
    Given Timeline has atleast 10 updates
    When Timeline is opened for the first time by user
    Then  User should see 10 updates in descending order of time when they were posted

  Scenario: User clicks on display more updates button on timeline
    Given Database has more then 20 posts
    When User clicks on display more updates button
    Then Timeline should display 10 additional updates with each click of "display more updates"

