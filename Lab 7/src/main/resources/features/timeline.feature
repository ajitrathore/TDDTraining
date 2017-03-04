Feature: Timeline display and ordering of updates


  Scenario: Timeline Display order
    Given Timeline has atleast 10 updates
    When Timeline is initialized by consumer
    Then  timeline should be loaded with 10 items in descending order of time when they were created

  Scenario: Consumer requests to fetch more items
    Given Database has more then 20 posts and timeline has been initialized
    When consumer requests more items using fetchItem
    Then Timeline should be loaded with 10 more items And total item count should be 20

