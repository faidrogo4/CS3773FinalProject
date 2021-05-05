package Model;

import javafx.scene.control.Label;

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
     * The account ID input at signup view
     *
     * @param accountPass
     * The password input at signup
     *
     */
    public Customer(String accountID,String accountPass) throws IncorrectPasswordException {
        super(accountID,accountPass);
        hist= new History();
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

    /**
     * getHist()
     *
     * getter for member hist
     *
     * @return
     * History for this customer
     */
    public History getHist(){
        return hist;
    }

    /**
     * setName(String, String)
     *
     * Sets the name values to be used by the screen when referring to the customer
     * @param first
     * The first name of the customer
     * @param last
     * The last name of the customer
     */
    public void setName(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * getFirstName()
     *
     * returns the first name value for this customer
     * @return
     * The first name value
     */
    public String getFirstName() {
        return this.firstName;
    }
}
