/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package post1;

/**
 *
 * @author Marco Chin
 */
public class Store {
    private boolean storeStatus = false;
    private String storeName;
    private Catalog cat;
    
    
    public Store(String name){
        storeName = name;
    }
    
    public String getName(){
        return storeName;
    }
    
    public void setName(String name){
        storeName = name;
    }
    
    public void setStoreStatus(boolean status){
        storeStatus = status;
    }
    
    public boolean getStoreStatus(){
        return storeStatus;
    }
    
    public void setCatalog(Catalog _cat){
        cat = _cat;
    }
    
    public Catalog getCatalog(){
        return cat;
    }
}
