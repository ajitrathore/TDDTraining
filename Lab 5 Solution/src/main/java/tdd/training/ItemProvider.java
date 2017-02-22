package tdd.training;

import java.util.List;

/**
 * Created by Ajit on 2/12/17.
 */
public interface ItemProvider {

    List<Item> fetchItems(int itemCount );

}
