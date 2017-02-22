package tdd.training.timeline.data.mongodb;

import org.bson.Document;
import tdd.training.timeline.model.Item;

/**
 * Created by Ajit on 2/19/17.
 */
public class DataItem implements Item{

    private long timeStamp;

    public DataItem(String message, long timeStamp) {
        this.message=message;
        this.timeStamp=timeStamp;
    }

    public String getMessage() {
        return message;
    }

    private String message;

    public DataItem(long timeStamp) {
        this.timeStamp=timeStamp;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    public Document getDocument()
    {
        return new Document("message",this.message).append("timeStamp",System.currentTimeMillis());
    }


}
