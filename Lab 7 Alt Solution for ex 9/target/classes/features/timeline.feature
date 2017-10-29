Feature: Timeline display and ordering of updates

  Scenario: Timeline Display order
    Given Timeline Database has atleast 10 items
    When Timeline is initialized by consumer
    Then  timeline should be loaded with 10 items from database
        And items should be sorted in descending order of date-time when items were created

  Scenario: Consumer requests to fetch more items
    Given Database has more then 20 items and timeline has been initialized
    When consumer requests more items
    Then Timeline should be loaded with 10 more items
      And total item count should be 20



