import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 *
 * @author Anwarul Patwary 
 * @version 1.00, 01 April 2022
 */

public class Order
{
    // instance variables 
    private FileReader file;
    private ArrayList<Product> product_list; 
    private String orderID;
    private double total_price;
    private double total_discount; 
    private String invoice_reference;
    private int total_item;

    /**
     * 1) Constructor for objects of class Order
     * 2) Initialise instance variables
     * 3) Provide the input file name and first letter of your first name and last as an order ID
     * e.g ("input.txt" "CP") CP for Collin Peter
     * 4) Get the list of lines from fileReader class. Create anonymous Product type of objects, then add them into product_list. 
     */
    public Order(String fileName, String order_id)
    {
        //TO DO 1
       this.orderID = order_id;
       this.file = new FileReader(fileName);
       product_list = new ArrayList<>();
       for (int i = 0; i< file.totalLines();i++){
           product_list.add(new Product(file.getLines().get(i)));
       }
    }

    /**
     * Generate invoice ID using OrderID and random generated value. String concatenation is applicable here. 
     * if orderID = "AN", and random value is 18. 
     * example output: AN18
     */

    public String generateInvoice(){
       //TO DO 8
        return this.orderID+String.valueOf(new Random().nextInt(100));
    }

    /**
     * 1) This method must communicate with Product class
     * 2) The method should be able to place the order using product id and unit. It will take one product item at a time. 
     * 3) Calculate the total payable amount by the customer
     * 4) To place multiple orders method should be able to get called multiple times. The total price and total discount will be accumulated to the field variable total_price total_discount respectively.
     * 5) Return the accumulated total price from this method
     * @param e.g prod_id = "P10982" and unit = 2
     * 6) Return the value with two decimal places. For Example: from 19.887 to 19.89
     */
    public double placeOrder(String prod_id, int unit){
    //TO DO 9
    Product productOrder = null;
    for (int i = 0; i < product_list.size(); i++) {
        Product productItem = product_list.get(i);
        if (productItem.getProductID().equals(prod_id)){
            productOrder= productItem;
            break;
        }
    }
    if (productOrder == null) {
    return 0.0;
    }
    double discount = (productOrder.getPrice() * unit)*(productOrder.getDiscount
    ()*0.01);
    double price = (productOrder.getPrice() * unit) - discount;
    price = new BigDecimal(String.valueOf(price)).setScale(2,
    RoundingMode.HALF_UP).doubleValue();
    this.total_price += price;
    this.total_discount += new BigDecimal(String.valueOf(discount)).setScale
    (2,RoundingMode.HALF_UP).doubleValue();
    this.total_item ++;
    return price;
}

    /**
     * 1) This method must communicate with Product class
     * 2) Return the accumulated total price after placing the order. 
     * 3) Return the value with two decimal places. For Example: from 19.887 to 19.89
     */
    
    public double getTotalPrice() { 
        //TO DO 10
        return new BigDecimal(String.valueOf(total_price)).setScale
        (2,RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 1) This method must communicate with Product class
     * 2) Get the accumulated total amount of discount that has been applied after placing the order.
     * 3) Return the value with two decimal places. For Example: from 1.113 to 1.11
     */

    public double getTotalDiscount(){
        //TO DO 11
        return new BigDecimal(String.valueOf(total_discount)).setScale
        (2,RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * Return total number of items ordered by a customer
     */
    public int getTotalItem(){
        //TO DO 12
        return total_item;
    }

    /**
     * print orders in the following format. 
     * *******Order Details*******
     * Invoice Number: AN43
     * Total items :2
     * Amount Payable: 36.7
     * Discount Applied: 2.4
     */

    public void printOrder(){
       //TO DO 13
       System.out.println(invoice_reference = "*******Order Details*******");
       System.out.println("Invoice Number: "+ generateInvoice());
       System.out.println("Total items :"+ getTotalItem());
       System.out.println("Amount Payable:" + getTotalPrice());
       System.out.println("Discount Applied:" + getTotalDiscount());
        
    }
    
}
