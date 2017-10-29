package tdd.training.timeline.data.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tdd.training.timeline.model.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by Ajit on 2/19/17.
 */
public class TImelineDataProviderTest {

    final MongoDBUtil mongoDBUtil = new MongoDBUtil();
    TimelineDataProvider timelineDataProvider=null;
    MongoCollection mockCollection=null;

    MongoCursor cursor=null;
    FindIterable iterable=null;

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

        mongoDBUtil.loadData(cursor);
        MockitoAnnotations.initMocks(this);
    }

    private void loadData() {


        mongoDBUtil.loadData(cursor);
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
    Exercise 5: Save an item and confirm that insert operation was invoked on database once.
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

        mongoDBUtil.loadData(cursor);

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
    public void getItemCount()
    {
        mongoDBUtil.loadData(cursor);
        dataItems .addAll(timelineDataProvider.fetchItems(getOldestItem(),20));

        mongoDBUtil.loadData(cursor);
        dataItems.addAll(timelineDataProvider.fetchItems(getOldestItem(),15));

        mongoDBUtil.loadData(cursor);

        final int TOTAL_COUNT=dataItems.size();


        FindIterable<Document> iterable= timelineDataProvider.getCollection().find();
        MongoCursor cursor=iterable.iterator();

        Set<DataItem> updates=new HashSet<DataItem>();

        long dbSize=0;

        while(cursor.hasNext() )
        {
            dbSize++;
        }

        when(mockCollection.count()).thenReturn(dbSize);

        assertTrue(TOTAL_COUNT==timelineDataProvider.getItemCount());

    }


}
