package Model;

import java.util.ArrayList;

public class Order extends Inventory {

    private Customer customer;

    /**
     * setCust(Customer)
     *
     * used by constructor to designate a customer.
     * @param customer
     * Customer to set current to
     */
    private void setCust(Customer customer){
        this.customer=customer;
    }

    /**
     * Order(Customer)
     *
     * Constructor. Should only be called from customer class
     *
     * @param customer
     * Customer that creates this order
     */
    public Order(Customer customer){
       this.p=new ArrayList<Product>();
       setCust(customer);
    }

    /**
     * getCustomer()
     * accesses the custoemer that created the order.
     *
     * @return
     * the customer that created this order
     */
    public Customer getCust(){return this.customer;}
}
