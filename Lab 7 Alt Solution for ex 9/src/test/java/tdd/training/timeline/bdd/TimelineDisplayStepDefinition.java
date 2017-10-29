package tdd.training.timeline.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tdd.training.timeline.data.mongodb.TimelineDataProvider;
import tdd.training.timeline.model.Timeline;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ajit on 2/22/17.
 */
public class TimelineDisplayStepDefinition {

    Timeline timeline=null;
    TimelineDataProvider timelineDataProvider=null;
    int INITIAL_TIMELINE_SIZE;


    @Given("^Timeline Database has atleast (\\d+) items$")
    public void timeline_Database_has_atleast_items(int itemCountEpectedInDatabase) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timelineDataProvider=new TimelineDataProvider();
        assertTrue(timelineDataProvider.getItemCount()>=itemCountEpectedInDatabase);    }

    @When("^Timeline is initialized by consumer$")
    public void timeline_is_initialized_by_consumer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timeline=new Timeline(timelineDataProvider);
        timeline.fetchItems();
    }

    @Then("^timeline should be loaded with (\\d+) items from database$")
    public void timeline_should_be_loaded_with_items_from_database(int fetchCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(timeline.getItems().size() == fetchCount);
    }

    @Then("^items should be sorted in descending order of date-time when items were created$")
    public void items_should_be_sorted_in_descending_order_of_date_time_when_items_were_created() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            for (int i=0;i<timeline.getItems().size()-1;i++)
                assertTrue(timeline.getItems().get(i).getTimeStamp()>timeline.getItems().get(i+1).getTimeStamp());
        }

    @Given("^Database has more then (\\d+) items and timeline has been initialized$")
    public void database_has_more_then_items_and_timeline_has_been_initialized(int itemCountEpectedInDatabase) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timelineDataProvider=new TimelineDataProvider();


        assertTrue(timelineDataProvider.getItemCount()>=itemCountEpectedInDatabase);
        timeline=new Timeline(timelineDataProvider);
        timeline.fetchItems();


    }

    @When("^consumer requests more items$")
    public void consumer_requests_more_items() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        INITIAL_TIMELINE_SIZE=timeline.getItems().size();
        timeline.fetchItems();
    }

    @Then("^Timeline should be loaded with (\\d+) more items$")
    public void timeline_should_be_loaded_with_more_items(int numberOfNewItems) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(timeline.getItems().size()==(INITIAL_TIMELINE_SIZE+numberOfNewItems));
    }

    @Then("^total item count should be (\\d+)$")
    public void total_item_count_should_be(int numberOfTotalItemsExpected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(timeline.getItems().size()==(numberOfTotalItemsExpected));
    }

    @Given("^Database has <number> items$")
    public void databaseHasNumberItems() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Consumer requests to save a new item$")
    public void consumer_requests_to_save_a_new_item() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Database should have <number \\+(\\d+) > Items$")
    public void database_should_have_number_Items(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



}
