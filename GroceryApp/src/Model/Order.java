package Model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;
    private Customer customer;
    /**
     *
     */
    private void setCust(Customer customer){
        this.customer=customer;
    }
    /**
     *
     */
    public Order(Customer customer){
       this.products=new ArrayList<Product>();
       setCust(customer);
    }
    /**
     *
     */
    public void add(Product newProduct, int count){
        if(products.contains(newProduct)){
            products.get(products.indexOf(newProduct)).add(count);
        }
    }
}
