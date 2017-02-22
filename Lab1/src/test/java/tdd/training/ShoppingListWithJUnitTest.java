package tdd.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ajit on 2/11/17.
 */
public class ShoppingListWithJUnitTest {
    ShoppingListWithJUnit shoppingList = null;

    @Before
    public void setUp() throws Exception {
        shoppingList=new ShoppingListWithJUnit();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getListOfItemForShopping() throws Exception {

        assertNotNull(shoppingList.getListOfItemsForShopping());
    }

    @Test
    public void setListOfItemForShopping() throws Exception {

        List myNewshoppingList = new ArrayList();
        shoppingList.setListOfItemsForShopping(myNewshoppingList);

        assertEquals(shoppingList.getListOfItemsForShopping(),myNewshoppingList);

    }

}