package Model;

public class Customer extends Account{

    /**
     * Account()
     * <p>
     * Creation of account with password and ID
     *
     * @param accountID
     */
    Customer(String accountID,String accountPass) {
        super(accountID,accountPass);
    }
}
