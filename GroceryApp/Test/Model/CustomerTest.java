package Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Customer Test")
class CustomerTest {

    @Test
    void nullPass(){

            assertThrows(Model.IncorrectPasswordException.class,()->{
            Customer newCust = new Customer("Test", null);
        });
    }
    @Test
    void emptyPass(){
        assertThrows(IncorrectPasswordException.class,()->{
            Customer newCust = new Customer("Test","");
        });
    }
    @Test
    void nullUser(){

        Customer newCust = null;
        try {
            newCust = new Customer(null,"test");
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }
        try {
            assertEquals("Account#" + newCust.getCount(), newCust.getID());
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("newCust was null.");
        }
    }
    @Test
    void emptyUser(){

        Customer newCust = null;
        try {
            newCust = new Customer("","test");
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }
        try {
            assertEquals("Account#" + newCust.getCount(), newCust.getID());
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("newCust was null.");
        }
    }
}