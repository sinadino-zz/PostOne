//Author: Michele

package post1;

/**
 *
 * @author mic
 */
public class CheckPayment extends Payment {
  public CheckPayment() {
      super();
  }

  @Override
  public boolean makePayment(){
      return true;
  }
  
  @Override
  public String makeReport(){
      return "Paid by Check";
  }
    
}
