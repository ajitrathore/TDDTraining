package tdd.training;

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

    private final Set<Item> items;

    ItemProviderStub() {
        items = new HashSet<Item>();
    }

    //configuration method
    public void addItems(Item... itemsToAdd) {
        items.addAll( asList( itemsToAdd ));

    }


    public List<Item> fetchItems(int fetchCount) {
        return items
                .stream()
                .limit( fetchCount )
                .collect( toList() );
    }
}
