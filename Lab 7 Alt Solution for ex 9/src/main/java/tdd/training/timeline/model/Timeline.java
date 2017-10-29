package tdd.training.timeline.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajit on 2/11/17.
 */
public class Timeline {
    private int fetchCount;

    private  final int DEFAULT_FETCH_COUNT=10;
    private final int FETCH_COUNT_UPPER_BOUND=20;
    private final int FETCH_COUNT_LOWER_BOUND=1;
    private ItemProvider itemProvider;
    private List<Item> items;

    public Timeline() {
        this.fetchCount=DEFAULT_FETCH_COUNT;
    }



    public Timeline(ItemProvider itemProvider) {
        this.itemProvider=itemProvider;
        this.items = new ArrayList<>();
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


    public ItemProvider getItemProvider() {
        return itemProvider;
    }

    public List<Item> getItems() {
        return items;
    }

    public void fetchItems() {

        items.addAll(  itemProvider.fetchItems(getOldestItem(), getFetchCount()));

    }

    public Item getTopItem() {
        if (items.size()==0)
        return null;
        else
            return items.get(0);
    }

    public Item getOldestItem() {
        if (items.size()==0)
            return null;
        else
            return items.get(items.size()-1);
    }


}
