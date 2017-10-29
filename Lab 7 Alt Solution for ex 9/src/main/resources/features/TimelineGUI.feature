Feature: Timeline UI Display

  Scenario: Mike opens Timeline UI
    Given class has posted atleast 10 items
    When Mike opens Timeline UI
    Then Mike Should see 10 items on timeline

    Scenario: Mike clicks on Load More Updates button
      Given Mike is on Timeline UI
      When Mike clicks on Load More Updates button
      Then Mike should see 20 items on Timeline
