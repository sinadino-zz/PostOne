/*
 * Abstract class person that contains first and last name
 * also retrieves first and last name of the person
 */
package post1;

/**
 *
 * @author ozan onder
 */
public abstract class Person 
{
    private String firstName;
    private String lastName;
    
    public Person(String firstName, String lastName)
    {
      this.firstName = firstName;
      this.lastName = lastName;
    } 
    
    //returns the fullname of the person
    public String getName()
    {
        String fullName = firstName + " " + lastName;
        return fullName;
    }        
            
}
