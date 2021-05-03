package Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Customer Test")
class CustomerTest {

    Customer testCust;
    String currentPass;
    String currentUser;
    @BeforeEach
    void setUp(){
        try {
            currentPass ="Test";
            currentUser = "Test";
            Customer testCust =  new Customer(currentUser, currentPass);
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }
    }

    @Test
    void nullPass(){

            assertThrows(Model.IncorrectPasswordException.class,()->{
            testCust = new Customer("Test", null);
        });
    }
    @Test
    void emptyPass(){

        assertThrows(IncorrectPasswordException.class,()->{
            testCust = new Customer("Test","");
        });
    }
    @Test
    void nullUser(){

        testCust = null;
        try {
            testCust = new Customer(null,"test");
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }
        try {
            assertEquals("Account#" + testCust.getCount(), testCust.getID());
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("newCust was null.");
        }
    }
    @Test
    void emptyUser(){

        testCust = null;
        try {
            testCust = new Customer("","test");
        } catch (IncorrectPasswordException e) {
            e.printStackTrace();
        }
        try {
            assertEquals("Account#" + testCust.getCount(), testCust.getID());
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("newCust was null.");
        }
    }
    @Test
    void updateNullPass(){
        assertThrows(IncorrectPasswordException.class, ()->{
            testCust.updatePass(currentPass,null);
        });

    }

    @Test
    void updateEmptyPass(){
        assertThrows(IncorrectPasswordException.class, ()->{
            testCust.updatePass(currentPass,"");
        });

    }

    @Test
    void updateWrongPass(){
        assertThrows(IncorrectPasswordException.class, ()->{
            testCust.updatePass("wrong","");
        });
    }
}