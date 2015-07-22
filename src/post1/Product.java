package post1;

/**
 *
 * @author lev
 */
public class Product {
    private String upc;
    private String name;
    private double price;
    
    public Product(String _upc, String _name, double _price){
        upc = _upc;
        name = _name;
        price = _price;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getUPC(){
        return upc;
    }
}
