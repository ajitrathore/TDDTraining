package tdd.training.timeline.model;

import tdd.training.timeline.data.mongodb.DataItem;

import java.util.List;

/**
 * Created by Ajit on 2/12/17.
 */
public class ItemProviderDummy implements ItemProvider {
    private static String MESSAGE
            = "Dummy method must never be called.";


    @Override
    public List<Item> fetchItems(Item ancestor, int itemCount) {
        throw new UnsupportedOperationException(MESSAGE);
    }

    @Override
    public long getItemCount() {
        throw new UnsupportedOperationException(MESSAGE);
    }

}
