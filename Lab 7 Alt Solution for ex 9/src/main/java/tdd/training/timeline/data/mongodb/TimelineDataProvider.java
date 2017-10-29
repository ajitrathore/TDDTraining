package tdd.training.timeline.data.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import tdd.training.timeline.model.Item;
import tdd.training.timeline.model.ItemProvider;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Long.compare;
import static java.util.stream.Collectors.toList;

/**
 * Created by Ajit on 2/19/17.
 */
public class TimelineDataProvider implements ItemProvider{
    private MongoDatabase database;
    private MongoCollection collection;

    public TimelineDataProvider() {
        this.database = new MongoClient(new MongoClientURI("mongodb://localhost:27017")).getDatabase("timelineDatabase");
        this.collection=this.database.getCollection("tddClass");
    }




    @Override
    public List<Item> fetchItems(Item ancestor, int count) {
        FindIterable<Document> iterable= getCollection().find();
        MongoCursor cursor=iterable.iterator();

        Set<DataItem> updates=new HashSet<DataItem>();
        while(cursor.hasNext() )
        {
            Document document= (Document) cursor.next();
            updates.add(new DataItem(document.getString("message"),document.getLong("timeStamp")));
        }
        return updates
                .stream()
                .sorted(descending())
                .filter(item -> isApplicable(ancestor,item))
                .limit(count)
                .collect( toList() );
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void saveUpdate(DataItem item) {
        getCollection().insertOne(item.getDocument());
    }

    public MongoCollection getCollection() {
        return collection;
    }

    private Comparator<? super DataItem> descending() {
        return ( first, second )
                -> compare( second.getTimeStamp(), first.getTimeStamp() );
    }

    private boolean isApplicable(Item ancestor, Item item) {
        return    ancestor == null
                || item.getTimeStamp() < ancestor.getTimeStamp();

    }

    @Override
    public long getItemCount() {
        return getCollection().count();
    }
}
