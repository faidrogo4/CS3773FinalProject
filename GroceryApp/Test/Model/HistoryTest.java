package Model;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    private History testHist;
    private Customer testCustomer;
    @BeforeEach
    void setUp() {
        testHist=new History();
        try {
            testCustomer = new Customer("Test", "Test");
        }catch (IncorrectPasswordException e){
            e.printStackTrace();
        }
        for(int i=0;i<3;i++){
            for(int j=1;j<4;j++) {
                testCustomer.getOrder().AddProduct(new Product("Prod" + (j+(3*i)), 1, 1.00, 1, 0));
            }
            testCustomer.checkout();
        }
        testHist = testCustomer.getHist();
    }

    @Test
    void getClone() {
        assertEquals(testHist.getClone(), testCustomer.getHist().getClone());
    }

    @Test
    void getLastOrder() {

        assertEquals("Prod9",testHist.getLastOrder().getListByName(false).get(0).getName());

    }

    @Test
    void addOrder() {
        testCustomer.getOrder().AddProduct( new Product("newProd",1,2.00,1,0));
        testHist.addOrder( testCustomer.getOrder());
        assertEquals("newProd",testHist.getLastOrder().getListByName(true).get(0).getName());
    }

    @Test
    void popOrder() {
        Order popped = testHist.popOrder();
        assertEquals("Prod6",testHist.getLastOrder().getListByName(false).get(0).getName());
    }
}