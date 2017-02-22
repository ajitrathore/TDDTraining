import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajit on 2/11/17.
 */
public class ShoppingListManual {
    public static void main(String[] args)
    {
        //Given that we have a new shopping list
        List listOfItemsForShopping = new ArrayList();

        System.out.println("Initial size of list is "+listOfItemsForShopping.size());

        //When we add an object in the shopping list

        Object objANewGroceryItem= new Object(  );

        listOfItemsForShopping.add(objANewGroceryItem);

        // then the size of shopping list should be 1

        System.out.println("After adding item, size of list "+listOfItemsForShopping.size());


    }
}
