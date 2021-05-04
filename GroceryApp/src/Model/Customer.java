package Model;

public class Customer extends Account{

    private Order current;
    private History hist;
    private String firstName;
    private String lastName;
    /**
     * Account()
     * <p>
     * Creation of account with password and ID
     *
     * @param accountID
     */
    public Customer(String accountID,String accountPass) throws IncorrectPasswordException {
        super(accountID,accountPass);
        current = null;
    }

    /**
     * createOrder()
     *
     * should be called when an order is accessed by the controller but the customer has no current order.
     */
    private Order createOrder(){
        if(current == null) {
            current = new Order(this);
        }
        return this.current;
    }

    /**
     * getOrder()
     *
     * @return
     * either the current order or creates a new order and returns that
     */
    private Order getOrder(){
        if(current!=null) {
            return this.current;
        }else{
            return createOrder();
        }
    }
    public void setName(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }
}
