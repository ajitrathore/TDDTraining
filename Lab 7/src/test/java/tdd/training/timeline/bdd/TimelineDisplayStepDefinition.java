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



    @Given("^Timeline has atleast (\\d+) updates$")
    public void timeline_has_atleast_updates(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timelineDataProvider=new TimelineDataProvider();
        assertTrue(timelineDataProvider.getItemCount()>=10);
    }

    @When("^Timeline is initialized by consumer$")
    public void timeline_is_initialized_by_consumer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timeline=new Timeline(timelineDataProvider);
        timeline.fetchItems();
    }

    @Then("^timeline should be loaded with (\\d+) items in descending order of time when they were created$")
    public void timeline_should_be_loaded_with_items_in_descending_order_of_time_when_they_were_created(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i=0;i<timeline.getItems().size()-1;i++)
            assertTrue(timeline.getItems().get(i).getTimeStamp()>timeline.getItems().get(i+1).getTimeStamp());
    }

    @Given("^Database has more then (\\d+) posts and timeline has been initialized$")
    public void database_has_more_then_posts_and_timeline_has_been_initialized(int arg1) throws Throwable {

        timelineDataProvider=new TimelineDataProvider();
        timeline=new Timeline(timelineDataProvider);
        timeline.fetchItems();
        INITIAL_TIMELINE_SIZE=timeline.getItems().size();

        assertTrue(timelineDataProvider.getItemCount()>=10);
    }

    @When("^consumer requests more items using fetchItem$")
    public void consumer_requests_more_items_using_fetchItem() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timeline.fetchItems();
    }

    @Then("^Timeline should be loaded with (\\d+) more items And total item count should be (\\d+)$")
    public void timeline_should_be_loaded_with_more_items_And_total_item_count_should_be(int numberOfNewItems, int totalItemCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        assertTrue(timeline.getItems().size()==numberOfNewItems+INITIAL_TIMELINE_SIZE);
        assertTrue(timeline.getItems().size()==totalItemCount);
        for (int i=0;i<totalItemCount-1;i++)
            assertTrue(timeline.getItems().get(i).getTimeStamp()>=timeline.getItems().get(i+1).getTimeStamp());
    }
}
