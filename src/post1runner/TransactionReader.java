//Author: Lev
package post1runner;

import java.io.BufferedReader;
import java.io.FileReader;
import post1.*;
import java.util.*;

/**
 *
 * @author lev
 */
public class TransactionReader {
    private BufferedReader reader;
    Sale currentSale;
    
    TransactionReader(String transactionFile){
        try{
            FileReader fr = new FileReader(transactionFile);
            reader = new BufferedReader(fr);
        }catch(Exception e){
            reader = null;
        }
    }
    
    boolean hasMoreTransactions(){
        if(reader == null){
            return false;
        }
        
        if(currentSale != null){
            return true;
        }
        
        currentSale = saleFromCurrentPosition();
        
        return (currentSale != null);
    }
    
    public Sale getNextSale(){
        if(this.hasMoreTransactions()){
            Sale toReturn = currentSale;
            currentSale = null;
            return toReturn;
        }else{
            return null;
        }
    }
    
    private Sale saleFromCurrentPosition(){
        try{
            String nextLine = reader.readLine();
            if(nextLine == null){
                reader.close();
                reader = null;
                return null;
            }else{
                ArrayList<String> transaction = new ArrayList<String>();
                
                while(nextLine.isEmpty() == false){
                    transaction.add(nextLine); //put each transaction into a list of strings.
                    nextLine = reader.readLine();
                }
                
                String custName = transaction.get(0);//element 0 is customer name
                String[] nameElems = custName.split("\\s+"); //reg expression to split at one or more whitespace chars.
                Customer customer;
                if(nameElems.length > 1){
                    customer = new Customer(nameElems[0], nameElems[1]);
                }else{
                    customer = new Customer(custName, "");
                }
                
                ArrayList<PurchaseItem> itemsToBuy = new ArrayList<PurchaseItem>();//list of items from current transaction
                
                for(int i = 1; i < transaction.size() - 1; i++){ //elements in between 0 and last are items.
                    String lineItem = transaction.get(i);
                    String[] itemElems = lineItem.split("\\s+");
                    PurchaseItem item;
                    if(itemElems.length > 1){
                        item = new PurchaseItem(itemElems[0], Integer.parseInt(itemElems[1])); // UPC +quantity
                    }else{
                        item = new PurchaseItem(lineItem, 1);//just UPC by itself
                    }
                    itemsToBuy.add(item);
                }
                
                String paymentString = transaction.get(transaction.size() - 1);//payment type is last element
                String[] paymentElems = paymentString.split("\\s+");
                String type = paymentElems[0];
                Payment payment;
                if(type.equals("<CASH")){
                    //ignore $ sign, > bracket
                    String tendered = paymentElems[1];
                    tendered = tendered.replaceAll("\\$", "");//remove dollar sign
                    tendered = tendered.replaceAll(">", "");//remove greater-than sign
                                   
                    payment = new CashPayment();                   
                    
                    ((CashPayment)payment).setAmountTendered(Double.parseDouble(tendered));
                    
                }else if(type.equals("<CHECK")){
                    payment = new CheckPayment();
                }else if(type.equals("<CREDIT")){
                    String ccNum = paymentElems[1].replaceAll(">", "");
                    
                    payment = new CreditCardPayment();
                    ((CreditCardPayment)payment).setCardNumber(ccNum);
                }else{
                    return null;
                }
                
                return new Sale(customer, itemsToBuy, payment);
                
            }
        }catch(Exception e){
            System.out.println("Transaction exception: " + e.getMessage());
            return null;
        }
    }
}
