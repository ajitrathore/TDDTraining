package tdd.training;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ajit on 2/11/17.
 */
public class TimelineTest {

    Timeline timeline=null;
    @Before
    public void setUp() throws Exception {
        ItemProvider itemProvider=new ItemProviderDummy();
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
        Timeline’s consumers should never be able to fetch less then 20 items.
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
    Lab 4
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

        itemProvider of timeline should not be null

     */
    @Test
    public void getItemProvider()
    {
        assertNotNull(timeline.getItemProvider());
    }


}
