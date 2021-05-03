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
        if(accountID==null||accountID.isEmpty()) {
            this.accountID ="Account#" + count;
        }else {
            this.accountID=ID;
        }
    }
    /**
     * setPass(String)
     *
     * private setter function for passphrase
     */
    private void setPass(String pass) throws IncorrectPasswordException{
        if(accountPass==null||accountPass.isEmpty()){
            throw new IncorrectPasswordException(accountPass+" is not an acceptable password");
        }else{
            this.accountPass=pass;
        }
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
        setID(accountID);
        setPass(accountPass);

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

    /**
     * getCount()
     *
     * returns count of customers
     */
    public int getCount(){
        return this.count;
    }

    /**
     * updatePass(String, String)
     *
     * Will update the pasword to the second string argument if the first string argument matches
     * the current password. Otherwise it will throw an inccorectPasswordException.
     */
    public void updatePass(String current, String newPass) throws IncorrectPasswordException{
        if(chkPass(current)){
            setPass(newPass);
        }else{
            throw new IncorrectPasswordException("The password you typed was incorrect");
        }
    }

}

