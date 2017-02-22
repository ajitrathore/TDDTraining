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

    @Given("^Timeline has atleast (\\d+) updates$")
    public void timelineHasAtleastUpdates(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^Timeline is opened for the first time by user$")
    public void timelineIsOpenedForTheFirstTimeByUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timelineDataProvider=new TimelineDataProvider();
        timeline=new Timeline(timelineDataProvider);
        timeline.fetchItems();

    }

    @Then("^User should see (\\d+) updates in descending order of time when they were posted$")
    public void userShouldSeeUpdatesInDescendingOrderOfTimeWhenTheyWerePosted(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (int i=0;i<timeline.getItems().size()-1;i++)
            assertTrue(timeline.getItems().get(i).getTimeStamp()>timeline.getItems().get(i+1).getTimeStamp());
    }

    @Given("^Database has more then (\\d+) posts$")
    public void databaseHasMoreThenPosts(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^User clicks on display more updates button$")
    public void userClicksOnDisplayMoreUpdatesButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Timeline should display (\\d+) additional updates with each click of \"([^\"]*)\"$")
    public void timelineShouldDisplayAdditionalUpdatesWithEachClickOf(int arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
