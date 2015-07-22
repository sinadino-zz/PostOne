
package post1;

import post1.Person;
import post1.Store;

/**
 *
 * @author Ozan Onder
 */
public class Manager extends Person
{
    public Manager(String firstName, String lastName)
    {
        //inherit the constructor from person class
        super(firstName, lastName);
    }
    
    public void openStore(Store store){
        store.setStoreStatus(true);
    }
    
    public void closeStore(Store store){
        store.setStoreStatus(false);
    }
}
