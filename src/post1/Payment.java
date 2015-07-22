//Author: Michele

package post1;

/** an abstract class representing a payment of some kind */
abstract public class Payment {
  public Payment() { 
      super();
  }
 
   // Declare variables.
     
    double amountOwed = 0;
    double amountPaid = 0;
    double totalChange = 0;

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  protected double amount;
  
  //returns true if payment succeeds, false if fails
  public boolean makePayment(){
      return false;
  }
  
  public String makeReport(){
      return "";
  }
}


      //Get input from user and calculate total change
     

