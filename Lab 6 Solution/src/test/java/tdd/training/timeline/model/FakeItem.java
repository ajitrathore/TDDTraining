package tdd.training.timeline.model;

/**
 * Created by Ajit on 2/14/17.
 */
public class FakeItem implements Item {
    long timeStamp;
    String message;



    public FakeItem(long timeStamp)
    {
        this.timeStamp=timeStamp;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
