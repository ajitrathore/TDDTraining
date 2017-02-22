package tdd.training;

/**
 * Created by Ajit on 2/11/17.
 */
public class Timeline {
    private int fetchCount;

    private  final int DEFAULT_FETCH_COUNT=10;
    private final int FETCH_COUNT_UPPER_BOUND=20;
    private final int FETCH_COUNT_LOWER_BOUND=1;
    public Timeline() {
        this.fetchCount=DEFAULT_FETCH_COUNT;
    }

    public void setFetchCount(int fetchCount) {
        if(fetchCount<=FETCH_COUNT_UPPER_BOUND && fetchCount>=FETCH_COUNT_LOWER_BOUND) {
            this.fetchCount = fetchCount;
        }
    }

    public int getFetchCount() {
        return fetchCount;
    }


}
