package tdd.training.timeline.data.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import tdd.training.timeline.model.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Ajit on 2/19/17.
 */
public class TImelineDataProviderTest {
    TimelineDataProvider timelineDataProvider=null;
    MongoCollection mockCollection=null;

    FindIterable iterable=null;
    MongoCursor cursor=null;

    List<Item> dataItems=null;

    MongoDatabase mockDatabase=null;

    MongoClient mockClient=null;

    @Before
    public void setUp() throws Exception {

        dataItems=new ArrayList<Item>();
        this.mockClient=mock(MongoClient.class);

        when(mockClient.getDatabase(anyString())).thenReturn(mockDatabase);

        this.mockCollection=mock(com.mongodb.client.MongoCollection.class);

        timelineDataProvider= Mockito.spy(new TimelineDataProvider());

        when(timelineDataProvider.getCollection()).thenReturn(mockCollection);

        iterable = mock(FindIterable.class);
        cursor = mock(MongoCursor.class);
        doReturn(mockCollection).when(timelineDataProvider).getCollection();


        when(mockCollection.find())
                .thenReturn(iterable);
        when(iterable.iterator()).thenReturn(cursor);

        //Setup Mock Data in database

        loadData();
        MockitoAnnotations.initMocks(this);
    }

    private void loadData() {
        when(cursor.hasNext()).thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);


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

        when(cursor.next()).thenReturn(document1)
                .thenReturn(document2)
                .thenReturn(document3)
                .thenReturn(document4)
                .thenReturn(document5)
                .thenReturn(document6)
                .thenReturn(document7)
                .thenReturn(document8)
                .thenReturn(document9)
                .thenReturn(document10)
                .thenReturn(document11)
                .thenReturn(document12)
                .thenReturn(document13)
                .thenReturn(document14)
                .thenReturn(document15)
                .thenReturn(document16)
                .thenReturn(document17)
                .thenReturn(document18)
                .thenReturn(document19)
                .thenReturn(document20)
                .thenReturn(null) ;
    }

    /*
    Lab 6
    Exercise 2: Create TimelineDataProvider, confirm that timelineDataProvider.getDatabase()
    is not null.

     */
    @Test
    public void whenInstantiatedThenDatabaseTypeIsNotNull() {

        assertNotNull(timelineDataProvider.getDatabase());

    }

    /*
    Lab 6
    Exercise 3: Confirm that timelineDataProvider.getDatabase().getName() is
    “timelineDatabase”.
     */

    @Test
    public void whenInstantiatedThenDatabaseName() {
        assertEquals("timelineDatabase", timelineDataProvider.getDatabase().getName());

    }

    /*
    Lab 6
    Exercise 4: Confirm that timelineDataProvider.getCollection is Not Null

     */

    @Test
    public void whenInstantiatedThenCollectionIsNotNull() {
        assertNotNull(timelineDataProvider.getCollection());
    }

    /*
    Lab 6
    Exercise 5: Save a post/update and confirm that insert operation was invoked on database once.
     */

    @Test
    public void whenSavingDataItemThenInvokingMongoCollection()
    {
        DataItem item=new DataItem("I love TDD!!" ,System.currentTimeMillis());
        timelineDataProvider.saveUpdate(item);
        verify(mockCollection,times(1)).insertOne(any(Document.class));

    }

    /*
     Lab 6
    Exercise 6: Given timelineDatabase has more then 10 items/records
When DataItemProvider fetchItem is called
Then It should return 10 records

     */

    @Test
    public void fetchItems()
    {
        assertTrue(timelineDataProvider.fetchItems(getOldestItem(), 10).size()==10);

    }



    public Item getOldestItem() {

        if ( dataItems.size()==0)
            return null;
        else
            return dataItems.get(dataItems.size()-1);
    }
 /*
 Lab 6
    Exercise 7:
Confirm that if fetchItems is returning items in the descending order of timestamp.

     */

 @Test
 public void fetchItemsDescending()
 {
     dataItems = timelineDataProvider.fetchItems(getOldestItem(),10);


     for(int i=0;i<dataItems.size()-1;i++) {
         assertTrue(dataItems.get(i).getTimeStamp() >= dataItems.get(i+1).getTimeStamp());

     }

 }

    /*
 Lab 6
    Exercise 8:
Confirm that if fetchItems is called second time then it returns older items in the order of timestamp.

     */

    @Test
    public void fetchOlderItems() {

        dataItems = timelineDataProvider.fetchItems(getOldestItem(),10);

        loadData();

        dataItems.addAll(timelineDataProvider.fetchItems(getOldestItem(), 10));

        for(int i=0;i<dataItems.size()-1;i++) {
            assertTrue(dataItems.get(i).getTimeStamp() >= dataItems.get(i+1).getTimeStamp());

        }
    }


    /*
 Lab 6
    Exercise 9:
    Implement a test to return total number of records in database.
     */

    @Test
    public void getTotalPostCount()
    {
        final int TOTAL_COUNT=dataItems.size();
        timelineDataProvider.getTotalPostCount();
    }
}
