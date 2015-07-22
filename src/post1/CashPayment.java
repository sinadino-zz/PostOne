//Author: Michele

package post1;

import java.text.DecimalFormat;


public class CashPayment extends Payment {
  public CashPayment() {
    super();
  }

  public double getAmountTendered() {
    return amountTendered;
  }

  public void setAmountTendered(double amountTendered) {
    this.amountTendered = amountTendered;
  }

  private double amountTendered;

  public double calcChange() {
    return amountTendered - super.getAmount();
  }
  
  @Override
  public boolean makePayment(){
      return (amountTendered > amount);
  }
  
  @Override
  public String makeReport(){
      DecimalFormat twoDecimals = new DecimalFormat("#.00");//use for getting the correct number if decimals for price.
      return "Amount Tendered: $" + twoDecimals.format(amountTendered) + "\n" + "Amount Returned: $" + twoDecimals.format(calcChange());
  }
  
}
