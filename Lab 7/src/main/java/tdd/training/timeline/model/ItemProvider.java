package tdd.training.timeline.model;

import tdd.training.timeline.data.mongodb.DataItem;

import java.util.List;

/**
 * Created by Ajit on 2/12/17.
 */
public interface ItemProvider {

    List<Item> fetchItems(Item ancestor, int itemCount );

    long getItemCount();
}
