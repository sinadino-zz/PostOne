package post1runner;
import post1.*;
/**
 *
 * @author lev/marco
 */
public class Post1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        //
        Store store = new Store("The Rumble Grocery"); //new store instance
        
        String workingDir = System.getProperty("user.dir");
        String productsFile = workingDir + "/src/resources/products.txt";
        ProductReader pr = new ProductReader(productsFile);
        Catalog cat = new Catalog();
        while(pr.hasMoreProducts()){
            Product nextP = pr.getNextProduct();
            cat.addProduct(nextP);
        }
        
        store.setCatalog(cat);
            
            
        Manager manager = new Manager("Michael", "Rogers");
        manager.openStore(store);//
      
        if(store.getStoreStatus()==true){
            String transactionFile = workingDir + "/src/resources/transaction.txt";
            TransactionReader tr = new TransactionReader(transactionFile);
            while(tr.hasMoreTransactions()){
                Sale nextS = tr.getNextSale();//tr retains info of sale object(customer, items, payment)
                try{
                    nextS.sell(store);
                }catch(Exception e){
                    System.out.println("\nError: " + e.getMessage());
                }
            }
        }
        manager.closeStore(store);
    }
        
    
}
