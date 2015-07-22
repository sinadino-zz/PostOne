//Author: Michele

package post1;
import java.util.Random;

  public class CreditCardPayment extends Payment {
  public CreditCardPayment() {
      super();
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  private boolean authorize() {  
    Random rand = new Random();
    int tenPercentRejected = rand.nextInt(10)+1;
    if (tenPercentRejected == 1){
        return false;
    }
    else
        return true;
  }

  private String cardNumber;
  
  @Override
  public boolean makePayment(){
      return true;
  }
  
  @Override
  public String makeReport(){
      if(authorize()==true)
          return "Credit Card " + cardNumber;
      else
          return "Unable to make purchase, Credit Card " + cardNumber + " DENIED";
  }
}

