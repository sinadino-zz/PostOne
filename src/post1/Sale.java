/**
 *
 * @author Marco Chin
 */
package post1;
import java.io.*;
import java.util.*;
import java.text.*;

public class Sale{
    
    Customer customer;
    ArrayList<PurchaseItem> items;
    Payment payment;
    
    public Sale(Customer _customer, ArrayList<PurchaseItem> _items, Payment _payment){
        customer = _customer;
        items = _items;
        payment = _payment;
    }
    
    public void sell(Store fromStore){
        double total = 0.0;
        for(PurchaseItem pi : items){ //loop to set the subtotals and total
            Product relevantProduct = fromStore.getCatalog().fetchProductByUPC(pi.getUPC());
            double cost = (relevantProduct.getPrice())*(pi.getQuantity());
            pi.setSubtotal(cost);
            total += cost;
        }
        
        payment.setAmount(total);
        if(payment.makePayment()){
            printReceipt(fromStore);
        }else{
            System.out.println("Payment failed");
        }
    }
    
    private void printReceipt(Store fromStore){
        //store name
        System.out.println(fromStore.getName());

        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//format the date like so
        Date date = new Date();//which date? this date
        
        //customer and date
        System.out.println(customer.getName() + "   " + dateFormat.format(date));
        
        DecimalFormat twoDecimals = new DecimalFormat("#.00");//use for getting the correct number of decimals for price.
        
        for(PurchaseItem pi : items){
            Product relevantProduct = fromStore.getCatalog().fetchProductByUPC(pi.getUPC());
            System.out.print(relevantProduct.getName() + " ");
            System.out.println("" + pi.getQuantity() + " @ $" + twoDecimals.format(relevantProduct.getPrice()) + " $" + twoDecimals.format(pi.getSubtotal()));
        }
        
        System.out.println("Total: $" + twoDecimals.format(payment.getAmount()));
        System.out.println(payment.makeReport());
        
        System.out.println(); //empty
    }
}
