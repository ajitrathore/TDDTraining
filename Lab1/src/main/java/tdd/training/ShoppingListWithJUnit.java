package tdd.training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajit on 2/11/17.
 */
public class ShoppingListWithJUnit {
    private List listOfItemsForShopping= new ArrayList();

    public ShoppingListWithJUnit()
    {

    }
    public List getListOfItemsForShopping() {
        return listOfItemsForShopping;
    }

    public void setListOfItemsForShopping(List listOfItemForShopping) {
        this.listOfItemsForShopping = listOfItemForShopping;
    }

    public void dispose() {

        // currently for demo only
    }

}
