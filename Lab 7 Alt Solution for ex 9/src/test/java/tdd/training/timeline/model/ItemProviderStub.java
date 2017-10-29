package tdd.training.timeline.model;

import tdd.training.timeline.data.mongodb.DataItem;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Long.compare;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by Ajit on 2/5/17.
 */
public class ItemProviderStub implements ItemProvider {

    public Set<Item> getItems() {
        return items;
    }

    private final Set<Item> items;

    ItemProviderStub() {
        items = new HashSet<Item>();
    }

    //configuration method
    public void addItems(Item... itemsToAdd) {
        items.addAll( asList( itemsToAdd ));
    }

    @Override
    public List<Item> fetchItems(Item ancestor, int itemCount) {

        return items
                .stream()
                .sorted(descending())
                .filter(item -> isApplicable(null,item))
                .limit( itemCount )
                .collect( toList() );
    }

    @Override
    public long getItemCount() {
        return getItems().size();
    }

    private boolean isApplicable(Item ancestor, Item item) {
        return    ancestor == null
                || item.getTimeStamp() < ancestor.getTimeStamp();

    }

    private Comparator<? super Item> descending() {
        return ( first, second )
                -> compare( second.getTimeStamp(), first.getTimeStamp() );
    }



}
