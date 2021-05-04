package Model;

import java.util.ArrayList;

public class Order extends Inventory {

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
       this.p=new ArrayList<Product>();
       setCust(customer);
    }
}
