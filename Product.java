import java.util.ArrayList;

/**
 *
 * @author Anwarul Patwary 
 * @version 1.00, 01 April 2022
 */

public class Product
{
    // instance variables 
    private String product_id;
    private double discount;
    private double price;
    private String store_id;
    private String prod_category;
    

    /**
     * Constructor for objects of class Product
     * Initialise instance variables
     */
    public Product(String product_details)
    {
        //TO DO 2   
        
        String[] list_details = product_details.split(" ");
        product_id = list_details[0];
        price= Double.parseDouble(list_details[1]);
        discount = Double.parseDouble(list_details[2]);
        store_id = list_details[3];
        prod_category = list_details[4];
        
    }
    
    /**
     * Return the product ID
     */
    public String getProductID(){
      //TO DO 3  
    return product_id;
    }
    
    /**
     * Return the product price
     */
    
    public double getPrice(){
    //TO DO 4
    return price;
    }
    
    /**
     * Return the discount of a product 
     */
    public double getDiscount(){
       //TO DO 5 
    return discount;
    }
  
    
   /**
    * Return the category of a product 
    */ 
    public String getCategory(){
    //TO DO 6 
    return prod_category;
    }
    
    /**
     * Return the store ID of a product 
     */
       public String getStoreID(){
    //TO DO 7 
    return store_id;
    }   
    
}
