import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajit on 2/11/17.
 */
public class ShoppingListAutomated {

    private static void assertTrue( boolean condition) throws Exception {
        if (! condition)
            throw new Exception("Test failed");
    }

    public static void main(String[] args)
    {
        //Given we have a List of size 0

        List listOfItemsForShopping = new ArrayList();
        try {
            assertTrue(listOfItemsForShopping.size() == 0);
        //When we add an object in the shopping list

        Object objANewGroceryItem= new Object();

        listOfItemsForShopping.add(objANewGroceryItem);

        // then the size of shoppinglist should be 1

        assertTrue(listOfItemsForShopping.size()== 1) ;



        /*
                Lab 1, excercise 2 - Implement  new test case-

                Add one object to listOfItemsForShopping
                And assertTrue that size of listOfItemsForShopping is 2
         */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
