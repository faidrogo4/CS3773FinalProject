package Model;

public class Account {
    private String accountPass;
    private String accountID;
    private static int count=0;
    /**
     * setID(String)
     *
     * Private setter function for unique object ID
     */
    private void setID(String ID){
        this.accountID = ID;
    }
    /**
     * setPass(String)
     *
     * private setter function for passphrase
     */
    private void setPass(String pass){
        this.accountPass=pass;
    }

    /**
     * chkID(String)
     * @param accountID
     * ID to be compared to this.accountID
     * @return
     * True if string passed matches this.accountID false otherwise
     */
    private boolean chkID(String accountID){
        return this.accountID.equals(accountID);
    }

    /**
     * boolean chkPass(String)
     * @param accountPass
     * Password to be compared to this.accountPass
     * @return
     * True if password is the same as this.accountPass false otherwise
     */
    private boolean chkPass(String accountPass){
        return this.accountPass.equals(accountPass);
    }

    /**
    * Account(String, String)
    *
    * Creation of account with password and ID
     * @param accountID
     * The name input to the user or null if default
     * @param accountPass
     * The password input at account creation. No possible default
    * */
    public Account( String accountID,  String accountPass) throws IncorrectPasswordException{
        count++;
        if(accountID.isEmpty()) {
            setID("Account#" + count);
        }else {
             setID(accountID);
        }
        if(accountPass.isEmpty()){
            throw new IncorrectPasswordException(accountPass+" is not an acceptable password");
        }else{
            setPass(accountPass);
        }
    }
    /**
     * getID()
     *
     * Returns the unique identifier string made at object initialization
     */
    public String getID(){
        return this.accountID;
    }

    /**
     * logon(String, String)
     *
     * returns true if the strings passed match the Account ID and Account password
     * otherwise returns false
     */
    public boolean logon(String accountID, String accountPass){
        return (chkID(accountID) && chkPass(accountPass));
    }

}

