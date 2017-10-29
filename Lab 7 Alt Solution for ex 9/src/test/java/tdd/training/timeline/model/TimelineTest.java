package tdd.training.timeline.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;


/**
 * Created by Ajit on 2/11/17.
 */
public class TimelineTest {

    FakeItem FAKE_ITEM_ONE=new FakeItem(10);
    FakeItem FAKE_ITEM_TWO=new FakeItem(20);
    FakeItem FAKE_ITEM_THREE=new FakeItem(30);
    FakeItem FAKE_ITEM_FOUR=new FakeItem(40);
    FakeItem FAKE_ITEM_FIVE=new FakeItem(50);
    FakeItem FAKE_ITEM_SIX=new FakeItem(60);
    FakeItem FAKE_ITEM_SEVEN=new FakeItem(70);


    Timeline timeline=null;
    ItemProviderStub itemProvider=null;

    @Before
    public void setUp() throws Exception {
        itemProvider=new ItemProviderStub();
        timeline=new Timeline(itemProvider);
    }

    /*
        Lab 2 - Excercise 2 - setFetchCount
        Test Scenario- Timeline should be able to set dataFetchCount
        with a number and Assert that used number is equal to new fetchCount.

     */

    @Test
    public void setFetchCount() throws Exception {
        //Given we have a new Fectch count

        final int NEW_FETCH_COUNT =15;

        //when we set the timeline fetchCount to New_Fetch_Count

        timeline.setFetchCount(NEW_FETCH_COUNT);

        //Then the New_Fetch_Count is equal to timeline.getFetchCount()
        assertTrue(timeline.getFetchCount()==NEW_FETCH_COUNT);

    }

    /*
    Lab 2 Exercise 3: In Initial state when setFetchCount has not been invoked,
    the default fetchCount should should be set to 10.
    */

    @Test
    public void initialStateFetchCount()
    {
        assertTrue(timeline.getFetchCount()==10);
    }

    /*
    Lab 2 Exercise 4:
    Test Scenario-
    Timeline should have upper bound for fetchCount set to 20.
    Timeline’s consumers should never be able to fetch more then 20 items.
    That means the fetchCount can never begreater then 20
    */

    @Test
    public void fetchCountExceedsUpperBound()
    {
         final int INITIAL_FETCH_COUNT=timeline.getFetchCount();
        timeline.setFetchCount(21);
        assertTrue(timeline.getFetchCount()<21);

    }

    /*
    Lab 2 - Exercise 5:
    Test Scenario-
        Exercise 5: Timeline should have lower bound for fetchCount set to 1.
        Timeline’s consumers should never be able to fetch less then 1 items.
        That means the fetchCount can never be less then 1
    */

    @Test
    public void setfetchCountLessThenLowerBound()
    {
        final int INITIAL_FETCH_COUNT=timeline.getFetchCount();
        timeline.setFetchCount(0);
        assertTrue(timeline.getFetchCount()>0);
    }

    /*
    Lab 3
    Exercise 1:
        Test Scenario-

        Consumers should be able to initialize timeline with ItemProvider object.
        We will create a dummy for item provider since at this stage we don’t have
        any need to invoke its behavior.
     */

    @Test
    public void initializeTimelineWithItemProvier()
    {
        ItemProvider itemProvider=new ItemProviderDummy();
        Timeline newTimeline=new Timeline(itemProvider);
        assertEquals(itemProvider,newTimeline.getItemProvider());
    }

/*
    Lab 4
    Exercise 2:
        Test Scenario-

        When Timeline has been initialized with an ItemProvider,
        Then getItemProvider should not be null
     */
    @Test
    public void getItemProvider()
    {
        assertNotNull(timeline.getItemProvider());
    }


    /*
    Lab 4
    Exercise 1:
    Test Scenario-
Timeline should be able to return list of items.


     */

    @Test
    public void getItems()
    {
        List<Item> items=timeline.getItems();
        assertNotNull(items);
    }

    /*
    Lab 4
    Exercise 2:
    Test Scenario-
Given ItemProvider has enough items,
When Timeline’s fetchCount is set to a value (say n) which is less then number number of items in itemProvider,
 Then Timeline should be able to fetch n number of items
     */

    @Test
    public void WhenItemProviderHasDatafetchItems()
    {
        itemProvider.addItems(FAKE_ITEM_ONE,FAKE_ITEM_TWO,FAKE_ITEM_THREE);
        timeline.setFetchCount(2);
        final int INITIAL_ITEM_COUNT=timeline.getItems().size();
        timeline.fetchItems();

        assertTrue((INITIAL_ITEM_COUNT+2)==timeline.getItems().size());
   }



  /*
    Lab 5
    Exercise 1:
    Test Scenario-
        Given ItemProvider has enough data,
When Timeline’s performs fetch requests
 Then Timeline’s items should be populated with items in descending order of timestamp on the item,
 that means that latest timeline updates (items) should show up at top

    */

    @Test
    public void fetchItemsReturnsDescending()
    {
        itemProvider.addItems(FAKE_ITEM_ONE,FAKE_ITEM_TWO,FAKE_ITEM_THREE, FAKE_ITEM_FOUR, FAKE_ITEM_FIVE, FAKE_ITEM_SIX);
        timeline.setFetchCount(4);
        timeline.fetchItems();

        List<Item> actual = timeline.getItems();
        assertArrayEquals(new Item[]{FAKE_ITEM_SIX, FAKE_ITEM_FIVE, FAKE_ITEM_FOUR, FAKE_ITEM_THREE }
        , actual.toArray());
    }

    @After
    public void tearDown() throws Exception {
        itemProvider=null;
    }
}
