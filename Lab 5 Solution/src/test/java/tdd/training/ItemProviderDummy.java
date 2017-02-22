package tdd.training;

import java.util.List;

/**
 * Created by Ajit on 2/12/17.
 */
public class ItemProviderDummy implements ItemProvider {
    private static String MESSAGE
            = "Dummy method must never be called.";


    @Override
    public List<Item> fetchItems(int itemCount) {
        throw new UnsupportedOperationException(MESSAGE);
    }
}
