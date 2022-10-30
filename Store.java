import java.util.ArrayList;
import java.math.*;
import java.util.Objects;
import java.math.RoundingMode;

/**
 *
 * @author Anwarul Patwary 
 * @version 1.00, 01 April 2022
 */

public class Store
{
    // instance variables 
    private FileReader file;
    private ArrayList<Product> listOfproduct;

    /**
     * 1) Constructor for objects of class Store
     * 2) Initialise instance variables
     * 2) Get the list of line from fileReader class. Create anonymous Product type of objects, then add them into listOfproduct.
     */
    
    public Store(String fileName)
    {
       //TO DO 14
       this.file = new FileReader(fileName);
       listOfproduct = new ArrayList<>();
       for(int i = 0; i<file.totalLines();i++){
           listOfproduct.add(new Product(file.getLines().get(i)));
       }
    }

    /**
     * 1)Find the most expensive product of a category.
     * @param e.g. "veg"
     * 2)Return the product id of the product.
     */
    public String expensiveItem(String prod_category)
    {
        //TO DO 15
        int expensiveItemIndex = -1;
        double expensivePrice = 0 ;
        for(int i = 0 ; i < listOfproduct.size() ;i++){
            double price = listOfproduct.get(i).getPrice();
            String category = listOfproduct.get(i).getCategory();
            if(!prod_category.equals(category)){
                continue;
            }
            if (price>expensivePrice){
                expensiveItemIndex = i;
                expensivePrice = listOfproduct.get(i).getPrice();
            }
        }
        return listOfproduct.get(expensiveItemIndex).getProductID();
    }

    /**
     * 1) Find the most expensive product of a category from a particular store.
     * 2) Return the product id and price of a product. Return the value in a single line as a string using string concatenation. 
     * Example output: P10982,21.0
     */

    public String expensiveItemStore(String prod_category, String store_id){
        //TO DO 16
        int expensiveItemIndex = -1;
        double expensivePrice = 0 ;
        for(int i = 0 ; i < listOfproduct.size() ;i++){
            Product product = listOfproduct.get(i);
            if (!product.getCategory().equals(prod_category) || !product.getStoreID
            ().equals(store_id)) {
                continue;
            }
            if (product.getPrice()>expensivePrice){
                expensiveItemIndex = i;
                expensivePrice = product.getPrice();
            }
        }
        Product MostExpensiveProduct = listOfproduct.get(expensiveItemIndex);
        return MostExpensiveProduct.getProductID
        ()+","+MostExpensiveProduct.getPrice();
    }

    /**
     * 1) Find the list of product and price which price is between "min" and "max". 
     * @param e.g min = 2, and max =10. 
     * 2) Return the list in an accumulated string using string concatenation.
     * 3) The list should be a String type, each product details seperate by a new line using "\n".  
     * 4) Throw an exception for a negative argument and "min" must not be greater than "max" value.
     * 
     * An example of returning list:
     * P10082,4.71
     * P10032,3.54
     */

    public String findProduct(int min, int max) {
        //TO DO 17
        if (min<0 || max <0){
        throw new IllegalArgumentException("Inputs must be greater than 0");
    }
    if (min > max){
        throw new IllegalArgumentException("Max price has to be greater than min price");
    }
    StringBuilder details = new StringBuilder();
    for (int i = 0 ; i< listOfproduct.size() ;i++){
        Product product = listOfproduct.get(i);
        double price = product.getPrice();
        if (price <= max && price >= min) {
            details.append(product.getProductID()).append(",").append
            (product.getPrice()).append("\n");
        }
    }
        return details.toString();
    } 

    /**
     * Use the prod_id to check the price of that product. Throw an exception if no product matches the product id.
     * @param e.g "P10982"
     */
    
    public double checkPrice(String prod_id) throws Exception{
        //TO DO 18
        for(int i = 0; i < listOfproduct.size() ; i++){
            if(Objects.equals(listOfproduct.get(i).getProductID(), prod_id)){
                return listOfproduct.get(i).getPrice();
            }
        }
        throw new Exception("Could not find the product ID");
    }

    /**
     * 1) Find the list of products in a store using a store ID. Return the product id and price using an ArrayList of String type
     * 2) Throw an exception if no store matches the store id.
     * @param e.g store_id = "S0198"
     * Example output: 
     * P10082,4.71
     * P10032,3.54
     */

    public ArrayList<String> getproductbyStoreID(String store_id) throws Exception{
        //TO DO 19
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listOfproduct.size(); i++){
            Product product = listOfproduct.get(i);
            if(store_id.equals(product.getStoreID())) {
                list.add(product.getProductID() + "," + product.getPrice());
            }
        }
        if (list.size() == 0) {
            throw new Exception();
        }
        return list;
    }

    /**
     * 1) Get the average cost of an item in an item category.
     * @param e.g "veg"
     * 2) Throw an exception in calculating the average that a value can not be divided by zero.
     * 3) Return the value with two decimal places. For Example: from 19.887 to 19.89
     */

    public double averageCost(String prod_category){
        //TO DO 20
        int amountOfCategory = 0;
        double totalPrice = 0;
        for (int i = 0; i < listOfproduct.size(); i++) {
            Product product = listOfproduct.get(i);
            if (Objects.equals(product.getCategory(), prod_category)) {
                amountOfCategory++;
                totalPrice += product.getPrice();
            }
        }
        if (amountOfCategory == 0) {
            throw new ArithmeticException();
        }
        return new BigDecimal(String.valueOf(totalPrice/amountOfCategory)).setScale
        (2, RoundingMode.HALF_UP).doubleValue(); 
    }
    
}
