/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package post1;
import java.util.*;

/**
 *
 * @author lev
 */
public class Catalog {
    private ArrayList<Product> products;
    
    public Catalog(){
        products = new ArrayList();
    }
    
    public void addProduct(Product toAdd){
        Product existenceCheck = fetchProductByUPC(toAdd.getUPC());
        if(existenceCheck == null){
            products.add(toAdd);
        }
    }
    
    public Product fetchProductByUPC(String upc){
        for(Product p : products){
            if(p.getUPC().equals(upc)){
                return p;
            }
        }
        
        return null;
    }
}