package tdd.training.timeline.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.bson.Document;
import tdd.training.timeline.data.mongodb.DataItem;
import tdd.training.timeline.data.mongodb.TimelineDataProvider;
import tdd.training.timeline.model.Item;
import tdd.training.timeline.model.Timeline;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ajit on 2/20/17.
 */
public class TimelineStepdefinition {
    TimelineDataProvider timelineDataProvider=null;
    Timeline timeline=null;
    long initialPostCount;
    @cucumber.api.java.en.Given("^database has more then (\\d+) posts$")
    public void databaseHasMoreThenPosts(int countOfUpdates) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timelineDataProvider=new TimelineDataProvider();


        initialPostCount=timelineDataProvider.getTotalPostCount();
    }

    private void loadData() {
        Document document1=new Document("message","I Love TDD").append("timeStamp",System.currentTimeMillis());

        Document document2=new Document("message","I Love TDD 2").append("timeStamp",System.currentTimeMillis()-20000);

        Document document3=new Document("message","I Love TDD 3").append("timeStamp",System.currentTimeMillis()-235000);

        Document document4=new Document("message","I Love TDD 4").append("timeStamp",System.currentTimeMillis()-235000);


        final Document document5 = new Document("message", "I Love TDD 5").append("timeStamp", System.currentTimeMillis() - 256800);
        final Document document6 = new Document("message", "I Love TDD 6").append("timeStamp", System.currentTimeMillis() - 3200);
        final Document document7 = new Document("message", "I Love TDD 7").append("timeStamp", System.currentTimeMillis() - 288);
        final Document document8 = new Document("message", "I Love TDD 8").append("timeStamp", System.currentTimeMillis() - 21230);
        final Document document9 = new Document("message", "I Love TDD 9").append("timeStamp", System.currentTimeMillis() - 10000);
        final Document document10 = new Document("message", "I Love TDD 10").append("timeStamp", System.currentTimeMillis() + 500);
        final Document document11 = new Document("message", "I Love TDD 11").append("timeStamp", System.currentTimeMillis() + 5000);
        final Document document12 = new Document("message", "I Love TDD 12").append("timeStamp", System.currentTimeMillis() + 1500);
        final Document document13 = new Document("message", "I Love TDD 13").append("timeStamp", System.currentTimeMillis() + 25500);
        final Document document14 = new Document("message", "I Love TDD 14").append("timeStamp", System.currentTimeMillis() + 64500);
        final Document document15 = new Document("message", "I Love TDD 15").append("timeStamp", System.currentTimeMillis() + 2900);
        final Document document16 = new Document("message", "I Love TDD 16").append("timeStamp", System.currentTimeMillis() + 287880);
        final Document document17 = new Document("message", "I Love TDD 17").append("timeStamp", System.currentTimeMillis() + 29000);
        final Document document18 = new Document("message", "I Love TDD 18").append("timeStamp", System.currentTimeMillis() + 21000);
        final Document document19 = new Document("message", "I Love TDD 19").append("timeStamp", System.currentTimeMillis() + 90000);
        final Document document20 = new Document("message", "I Love TDD 20").append("timeStamp", System.currentTimeMillis() + 800000);

        timelineDataProvider.getCollection().insertOne( document1);
        timelineDataProvider.getCollection().insertOne( document2);
        timelineDataProvider.getCollection().insertOne( document3);
        timelineDataProvider.getCollection().insertOne( document4);
        timelineDataProvider.getCollection().insertOne( document5);
        timelineDataProvider.getCollection().insertOne( document6);
        timelineDataProvider.getCollection().insertOne( document7);
        timelineDataProvider.getCollection().insertOne( document8);
        timelineDataProvider.getCollection().insertOne( document9);
        timelineDataProvider.getCollection().insertOne( document10);
        timelineDataProvider.getCollection().insertOne( document11);
        timelineDataProvider.getCollection().insertOne( document12);
        timelineDataProvider.getCollection().insertOne( document13);
        timelineDataProvider.getCollection().insertOne( document14);
        timelineDataProvider.getCollection().insertOne( document15);
        timelineDataProvider.getCollection().insertOne( document16);
        timelineDataProvider.getCollection().insertOne( document17);
        timelineDataProvider.getCollection().insertOne( document18);
        timelineDataProvider.getCollection().insertOne( document19);
        timelineDataProvider.getCollection().insertOne( document20);
    }

    @When("^Timeline is initialized with a dataprovider$")
    public void timelineIsInitializedWithADataprovider() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timeline = new Timeline(timelineDataProvider);

    }

    @Then("^Timeline should be able to fetch (\\d+) posts$")
    public void timelineShouldBeAbleToFetchPosts(int countOfUpdates) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        timeline.fetchItems();
        assertTrue(timeline.getItems().size()==10);
    }
}
